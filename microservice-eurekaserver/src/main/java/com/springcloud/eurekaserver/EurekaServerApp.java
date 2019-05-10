package com.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer    //启用服务注册中心
public class EurekaServerApp {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerApp.class,args);
    }

}
