package com.zhaoqingwang.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 23:00
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/returnId/{id}")
    public String returnId(@PathVariable("id") String id);

    @GetMapping("/payment/hystrix/returnIdTimeout/{id}")
    public String returnIdTimeout(@PathVariable("id") String id);
}
