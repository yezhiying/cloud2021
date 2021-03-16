package com.zhaoqingwang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 19:47
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006.class,args);
    }
}
