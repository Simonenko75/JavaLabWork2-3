package com.example.sub.module.service;

import com.example.sub.module.model.UserEntity;
import com.example.sub.module.model.UserEntityDTO;
import com.example.sub.module.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntityDTO getUserByLogin(String login) {
        UserEntityDTO userEntityDTO = new UserEntityDTO();
        Optional<UserEntity> optionalUserEntity = userRepository.findByLogin(login);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntityDTO.setLogin(userEntity.getLogin());
            userEntityDTO.setPassword(userEntity.getPassword());
        }
        return userEntityDTO;
    }

    public void addUser(UserEntityDTO userEntityDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userEntityDTO.getLogin());
        userEntity.setPassword(userEntityDTO.getPassword());
        userRepository.save(userEntity);
    }

}
