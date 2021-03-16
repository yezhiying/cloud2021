package com.zhaoqingwang.cloud.service;

import com.zhaoqingwang.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PayFeignService {

    @GetMapping("/payment/id/{id}")
    CommonResult selectById(@PathVariable("id") Long id);


    @GetMapping("/payment/timeout")
    String timeout();
}
