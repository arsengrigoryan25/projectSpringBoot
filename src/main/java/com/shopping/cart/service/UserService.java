package com.shopping.cart.service;

import com.shopping.cart.domain.dto.User;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired// Autowired te Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void creatUser(User user) {
        UserEntity entity = new UserEntity(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
        try{
            userRepository.save(entity);  //TODO petqa handle arvi user-i linelu case
        }catch (Exception e){

        }
    }

    public void deleteUser(String id) {
        Integer id1 = new Integer(id);
        userRepository.deleteById(id1);
    }
}
