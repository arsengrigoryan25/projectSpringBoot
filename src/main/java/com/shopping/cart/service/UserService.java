package com.shopping.cart.service;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
