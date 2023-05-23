package com.example.module.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private SubModuleApi subModuleApi;
    public ResponseDTO login(UserEntityDTO loginDTO) {
        UserEntityDTO userEntityDTO = subModuleApi.getUserByLogin(loginDTO.getLogin());
        ResponseDTO responseDTO = new ResponseDTO();
        if (userEntityDTO.getPassword() != null && userEntityDTO.getPassword().equals(loginDTO.getPassword())) {
            responseDTO.setMessage("Authorized");
            return responseDTO;
        }

        responseDTO.setMessage("Not authorized");
        return responseDTO;
    }
}


