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
    private OrderRepository orderRepository;

    @Autowired
    private UserModuleApi userModuleApi;

    public ResponseDTO getUserByOrder(UserEntityDTO userOrdersDTO) {
        UserEntityDTO userEntityDTO = userModuleApi.getUserByOrder(userOrdersDTO.getOrders());
        ResponseDTO responseDTO = new ResponseDTO();
        if (userOrdersDTO.getOrders() != null) {
            responseDTO.setMessage("Order was find");
            return responseDTO;
        }

        responseDTO.setMessage("Order was not find");
        return responseDTO;
    }

    public OrderEntityDTO orderAdd(OrderEntityDTO orderEntityDTO) {
        List<OrderEntityDTO> resultList = new ArrayList<>();
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

}
