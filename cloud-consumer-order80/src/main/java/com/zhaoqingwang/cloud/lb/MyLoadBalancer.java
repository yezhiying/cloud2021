package com.zhaoqingwang.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 20:51
 **/
public interface MyLoadBalancer  {

    ServiceInstance instance (List<ServiceInstance> serviceInstances);
}
