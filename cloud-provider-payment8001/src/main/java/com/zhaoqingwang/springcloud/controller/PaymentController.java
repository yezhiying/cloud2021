package com.zhaoqingwang.springcloud.controller;

import com.zhaoqingwang.cloud.entity.CommonResult;
import com.zhaoqingwang.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/15 21:30
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;

    private final DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/id/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        try {
            return new CommonResult<>(200, "查询成功,查询端口" + port, paymentService.getById(id));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new CommonResult<>(400, "查询失败", null);

        }
    }

    @GetMapping("/discovery")
    public Object getDiscovery() {
        discoveryClient.getServices().forEach(item -> {
            log.info("*******8element:" + item);
        });

        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(item -> {
            log.info(item.getInstanceId() + "\t" + item.getHost() + "\t" + item.getPort() + "\t" + item.getUri());
        });

        return this.discoveryClient;
    }
}
