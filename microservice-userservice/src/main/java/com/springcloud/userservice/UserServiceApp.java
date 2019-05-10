package com.springcloud.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApp {

    @Bean
    @LoadBalanced //适用负载均衡  ，并且可以保证使用服务名称访问应用
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args){
        SpringApplication.run(UserServiceApp.class,args);
    }

}
