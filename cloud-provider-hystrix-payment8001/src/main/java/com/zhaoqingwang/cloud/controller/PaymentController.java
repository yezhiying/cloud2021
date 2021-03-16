package com.zhaoqingwang.cloud.controller;

import com.zhaoqingwang.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 22:31
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/returnId/{id}")
    public String returnId(@PathVariable("id") String id){
        log.info("**********result:"+paymentService.returnId(id));
      return   this.paymentService.returnId(id);

    }

    @GetMapping("/payment/hystrix/returnIdTimeout/{id}")
    public String returnIdTimeout(String id){
        log.info("**********result:"+paymentService.returnIdTimeout(id));
        return paymentService.returnIdTimeout(id);
    }
}
