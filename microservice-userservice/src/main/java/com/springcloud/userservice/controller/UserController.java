package com.springcloud.userservice.controller;

import com.springcloud.userservice.mapper.UserMapper;
import com.springcloud.userservice.pojo.Order;
import com.springcloud.userservice.pojo.User;
import com.springcloud.userservice.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${ORDERSERVICEURL}")
    private String DERSERVICEURL;
    @GetMapping("/findOrders/{username}")
    public List<Order> getOrderByUsername(@PathVariable String username){
        User user = userService.selectUser(username);
        //使用Robbon后，可以使用http://order-service/ 而不是用IP：port
        ResponseEntity<List<Order>> responseEntity =
                restTemplate.exchange(DERSERVICEURL + "order/findOrder/" + user.getId(), HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Order>>(){});
        return responseEntity.getBody();
    }



}
