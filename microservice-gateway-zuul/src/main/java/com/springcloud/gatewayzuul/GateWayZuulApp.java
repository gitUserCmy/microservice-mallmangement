package com.springcloud.gatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient   //启动Eureka 客户端注册
@EnableZuulProxy     //开启Zuul 的API 网关服务
public class GateWayZuulApp {

    public static void main(String[] args){
        SpringApplication.run(GateWayZuulApp.class,args);
    }
}
