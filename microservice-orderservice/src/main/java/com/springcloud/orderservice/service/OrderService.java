package com.springcloud.orderservice.service;


import com.springcloud.orderservice.pojo.Order;

import java.util.List;

public interface OrderService {



    List<Order> getOrder(Integer userid);

}
