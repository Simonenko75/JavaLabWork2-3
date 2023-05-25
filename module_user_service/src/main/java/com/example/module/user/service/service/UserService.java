package com.example.module.user.service.service;

import com.example.module.user.service.model.UserEntity;
import com.example.module.user.service.model.UserEntityDTO;
import com.example.module.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserEntity addUser(UserEntityDTO userEntityDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userEntityDTO.getLogin());
        userEntity.setPassword(userEntityDTO.getPassword());
        userEntity.setOrders(userEntityDTO.getOrders());
        return userRepository.save(userEntity);
    }

    public UserEntityDTO getUserByLogin(String login) {
        UserEntityDTO userEntityDTO = new UserEntityDTO();
        Optional<UserEntity> optionalUserEntity = userRepository.findByLogin(login);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntityDTO.setId(userEntity.getId());
            userEntityDTO.setLogin(userEntity.getLogin());
            userEntityDTO.setPassword(userEntity.getPassword());
            userEntityDTO.setOrders(userEntity.getOrders());
        }

        return userEntityDTO;
    }

    public UserEntityDTO getUserByOrders(String orders) {
        UserEntityDTO userEntityDTO = new UserEntityDTO();
        Optional<UserEntity> optionalUserEntity = userRepository.findByOrders(orders);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntityDTO.setId(userEntity.getId());
            userEntityDTO.setLogin(userEntity.getLogin());
            userEntityDTO.setPassword(userEntity.getPassword());
            userEntityDTO.setOrders(userEntity.getOrders());
        }

        return userEntityDTO;
    }

}
