package com.zhaoqingwang.cloud.controller;

import com.zhaoqingwang.cloud.entity.CommonResult;
import com.zhaoqingwang.cloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private MyLoadBalancer myLoadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;



    @GetMapping("/payment/id/{id}")
    public CommonResult getById(@PathVariable long id) {
        try {
            return restTemplate.getForObject(PAYMENT_URL + "/payment/id/" + id, CommonResult.class);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new CommonResult<>(400, "查询失败", null);
        }
    }

    @GetMapping("/payment/get/id/{id}")
    public CommonResult getById2(@PathVariable long id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/id/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult<>(400, "查询失败", null);
        }
    }

    @GetMapping("/payment/ribbon")
    public Object getPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size()<=0) {
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/ribbon",String.class);
    }
}
