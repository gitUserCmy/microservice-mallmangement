package com.springcloud.orderservice.service;

import com.springcloud.orderservice.mapper.OrderMapper;
import com.springcloud.orderservice.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrder(Integer userid) {
        return orderMapper.getOrder(userid);
    }
}
