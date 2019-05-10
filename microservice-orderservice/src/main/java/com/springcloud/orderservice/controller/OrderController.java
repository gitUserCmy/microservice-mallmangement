package com.springcloud.orderservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.orderservice.pojo.Order;
import com.springcloud.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findOrder/{userid}")
    @HystrixCommand(fallbackMethod = "fallbackfindOrder")  //熔断器功能
    public List<Order> findOrder(@PathVariable Integer userid){
        return orderService.getOrder(userid);
    }


    public List<Order> fallbackfindOrder(@PathVariable Integer userid){
        return new ArrayList<Order>();
    }


}
