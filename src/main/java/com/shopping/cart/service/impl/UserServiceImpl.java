package com.shopping.cart.service.impl;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.repository.RoleRepository;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.security.UserPrinciple;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String creatUser(UserDto dto) {
        UserEntity entity = new UserEntity(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword());
        try {
            userRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            return "Tvyal email-ov user ka";
        }
        return "User is added";
    }
    @Override
    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public String deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return "User not found";
        }
        return "User is deleted";
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found with -> email : " + email)
                );

        return UserPrinciple.build(user);
    }

}
