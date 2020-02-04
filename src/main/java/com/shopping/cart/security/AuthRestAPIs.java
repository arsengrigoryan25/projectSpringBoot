//package com.shopping.cart.security;
//
//import com.shopping.cart.domain.entity.RoleEntity;
//import com.shopping.cart.domain.entity.UserEntity;
//import com.shopping.cart.message.request.LoginForm;
//import com.shopping.cart.message.response.JwtResponse;
//import com.shopping.cart.repository.RoleRepository;
//import com.shopping.cart.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashSet;
//import java.util.Set;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/")
//public class AuthRestAPIs {
//
//    private final AuthenticationManager authenticationManager;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder encoder;
//    private final JwtProvider jwtProvider;
//
//    @Autowired
//    public AuthRestAPIs(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JwtProvider jwtProvider) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.encoder = encoder;
//        this.jwtProvider = jwtProvider;
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getEmail(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtProvider.generateJwtToken(authentication);
//        return ResponseEntity.ok(new JwtResponse(jwt));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        UserEntity user = new UserEntity(
//                signUpRequest.getName(),
//                signUpRequest.getSurname(),
//                signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//
////        Set<String> strRoles = signUpRequest.getRole();
//        Set<RoleEntity> roles = new HashSet<>();
//
//        RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//        roles.add(userRole);
//
////        strRoles.forEach(role -> {
////            switch(role) {
////                case "admin":
////                    RoleEntity adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
////                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Admin Role not find."));
////                    roles.add(adminRole);
////                    break;
////                default:
////                    RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
////                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
////                    roles.add(userRole);
////            }
////        });
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        return ResponseEntity.ok().body("User registered successfully!");
//    }
//}