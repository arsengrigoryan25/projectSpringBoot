package com.shopping.cart.model.service.impl;

import com.shopping.cart.model.domain.dto.UserDto;
import com.shopping.cart.model.domain.entity.UserEntity;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.model.service.mapper.UserMapper;
import com.shopping.cart.model.repository.UserRepository;
import com.shopping.cart.security.UserPrinciple;
import com.shopping.cart.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity creatUser(UserEntity dto) {
        UserEntity entity = new UserEntity(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword());
        try {
            return userRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_EXIST);
        }
    }
    @Override
    public Iterable<UserDto> getAllUsers() {
        return userMapper.entityListToDtoList(userRepository.findAll());
    }
    @Override
    public Long deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_NOT_FOUND);
        }
        return id;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException("User Not Found with -> email : " + email));
        return UserPrinciple.build(user);
    }

}
