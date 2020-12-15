package com.shopping.cart.service.impl;

import com.shopping.cart.model.domain.dto.UserDto;
import com.shopping.cart.model.domain.entity.UserEntity;
import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.service.mapper.UserMapper;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.security.UserPrinciple;
import com.shopping.cart.service.UserService;
import org.mapstruct.factory.Mappers;
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
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        userMapper= Mappers.getMapper(UserMapper.class);
    }

    @Override
    public UserDto creatUser(UserDto dto) {

        UserEntity entity = userMapper.dtoToEntity(dto);
        try {
            entity = userRepository.save(entity);
            dto = userMapper.entityToDto(entity);

            return dto;
        } catch (DataIntegrityViolationException e) {
            throw new CustomRuntimeException(ErrorMessageEnum.USER_EXIST);
        }
    }
    @Override
    public Iterable<UserDto> getAllUsers() {

        Iterable<UserEntity> entities = userRepository.findAll();
        Iterable<UserDto>  userList = userMapper.entityListToDtoList(entities);

        return userList;
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
