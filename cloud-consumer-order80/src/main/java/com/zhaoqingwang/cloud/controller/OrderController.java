package com.zhaoqingwang.cloud.controller;

import com.zhaoqingwang.cloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/15 22:14
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //    private static final String PAYMENT_URL ="HTTP://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/id/{id}")
    public CommonResult getById(@PathVariable long id) {
        try {
            return restTemplate.getForObject(PAYMENT_URL + "/payment/id/" + id, CommonResult.class);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new CommonResult<>(400, "查询失败", null);
        }
    }
}
