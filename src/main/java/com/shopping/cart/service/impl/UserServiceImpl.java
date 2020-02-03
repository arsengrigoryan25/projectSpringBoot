package com.shopping.cart.service.impl;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.repository.RoleRepository;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String creatUser(UserDto dto) {
        UserEntity entity = new UserEntity(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword());
        try {
            userRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            return "Tvyal email-ov user ka";
        }
        return "User is added";
    }

    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return "User not found";
        }
        return "User is deleted";
    }

    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );

        return UserPrinciple.build(user);
    }

}
