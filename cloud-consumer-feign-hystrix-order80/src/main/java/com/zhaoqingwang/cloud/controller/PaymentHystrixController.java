package com.zhaoqingwang.cloud.controller;

import com.zhaoqingwang.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 23:03
 **/
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/returnId/{id}")
    public String returnId(@PathVariable("id") String id){
        String result = paymentHystrixService.returnId(id);
        return result;
    }


    @GetMapping("/payment/hystrix/returnIdTimeout/{id}")
    public String returnIdTimeout(@PathVariable("id") String id){
        String result = paymentHystrixService.returnIdTimeout(id);
        return result;
    }
}
