package com.zhaoqingwang.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 19:50
 **/
@RestController
@Slf4j
public class OrderConsulController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consumer/payment/consul")
    public String paymentConsul(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
