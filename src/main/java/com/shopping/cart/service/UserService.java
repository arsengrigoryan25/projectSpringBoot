package com.shopping.cart.service;

import com.shopping.cart.domain.dto.UserDto;
import com.shopping.cart.domain.entity.UserEntity;
import com.shopping.cart.repository.RoleRepository;
import com.shopping.cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    public String creatUser(UserDto dto) ;

    public Iterable<UserEntity> getAllUsers();

    public String deleteUser(Integer id) {;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;

}
