package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.UserDto;
import com.shopping.cart.model.domain.entity.RoleEntity;
import com.shopping.cart.service.mapper.UserMapper;
import com.shopping.cart.security.JwtResponse;
import com.shopping.cart.repository.RoleRepository;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.security.JwtProvider;
import com.shopping.cart.model.domain.enums.RoleName;
import com.shopping.cart.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600) /// - ????
@RequestMapping("/user")
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtProvider jwtProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser( @RequestBody UserDto userDto){  // @Valid-???
        if(userRepository.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<String>("Email is already in use!", HttpStatus.BAD_REQUEST);
        }

//        Set<String> strRoles = signUpRequest.getRole();
        Set<RoleEntity> roles = new HashSet<>();

        RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);

//        strRoles.forEach(role -> {
//            switch(role) {
//                case "admin":
//                    RoleEntity adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Admin Role not find."));
//                    roles.add(adminRole);
//                    break;
//                default:
//                    RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                    roles.add(userRole);
//            }
//        });

        userDto.setPassword(encoder.encode(userDto.getPassword()));
        userDto.setRoles(roles);
        userService.creatUser(userDto);

        return ResponseEntity.ok().body("User registered successfully!");
    }

    @GetMapping("/find")
    public Iterable<UserDto> getAllUsers(){ return userService.getAllUsers(); }

    @DeleteMapping("/delete")
    public Long deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }
}