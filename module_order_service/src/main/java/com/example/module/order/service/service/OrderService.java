package com.example.module.order.service.service;

import com.example.module.order.service.model.OrderEntity;
import com.example.module.order.service.model.OrderEntityDTO;
import com.example.module.order.service.model.ResponseDTO;
import com.example.module.order.service.model.UserEntityDTO;
import com.example.module.order.service.repository.OrderRepository;
import com.example.module.order.service.repository.UserModuleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    private UserModuleApi userModuleApi;

    public OrderEntityDTO orderAdd(OrderEntityDTO orderEntityDTO) {
        OrderEntity orderEntity =  new OrderEntity();
        orderEntity.setName(orderEntityDTO.getName());
        orderEntity.setTitles(orderEntityDTO.getTitles());
        orderEntity.setQuantity(orderEntityDTO.getQuantity());
        orderRepository.save(orderEntity);

        OrderEntityDTO orderEntityResponseDTO = new OrderEntityDTO();
        orderEntityResponseDTO.setId(orderEntity.getId());
        orderEntityResponseDTO.setName(orderEntity.getName());
        orderEntityResponseDTO.setTitles(orderEntity.getTitles());
        orderEntityResponseDTO.setQuantity(orderEntity.getQuantity());
        return orderEntityResponseDTO;
    }

    public ResponseDTO getUserIdByLogin(String login) {
        UserEntityDTO userEntityDTO = userModuleApi.getUserIdByLogin(login);
        ResponseDTO responseDTO = new ResponseDTO();
        if (userEntityDTO.getId() != null) {
            responseDTO.setMessage(userEntityDTO.getId().toString());
            return responseDTO;
        }

        responseDTO.setMessage("Id was not find");
        return responseDTO;
    }

    public ResponseDTO getUserByOrder(String orders) {
        UserEntityDTO userEntityDTO = userModuleApi.getUserByOrder(orders);
        ResponseDTO responseDTO = new ResponseDTO();
        if (userEntityDTO.getLogin() != null) {
            responseDTO.setMessage(userEntityDTO.getLogin());
            return responseDTO;
        }

        responseDTO.setMessage("Login was not find");
        return responseDTO;
    }

}
