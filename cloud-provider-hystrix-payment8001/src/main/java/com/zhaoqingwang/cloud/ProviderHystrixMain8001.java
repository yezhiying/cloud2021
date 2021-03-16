package com.zhaoqingwang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 22:21
 **/
@SpringBootApplication
@EnableEurekaClient
public class ProviderHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixMain8001.class,args);
    }
}
