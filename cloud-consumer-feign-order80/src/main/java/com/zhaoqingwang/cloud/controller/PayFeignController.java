package com.zhaoqingwang.cloud.controller;

import com.zhaoqingwang.cloud.entity.CommonResult;
import com.zhaoqingwang.cloud.service.PayFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 21:32
 **/
@RestController
public class PayFeignController {

    @Resource
    private PayFeignService payFeignService;

    @GetMapping("/feign/payment/id/{id}")
    public CommonResult selectById(@PathVariable Long id){
        return payFeignService.selectById(id);
    }


    @GetMapping("/feign/payment/timeout")
    public String timeout(){
        return payFeignService.timeout();
    }
}

