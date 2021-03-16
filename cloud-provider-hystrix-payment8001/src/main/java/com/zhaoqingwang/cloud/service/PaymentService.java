package com.zhaoqingwang.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 22:23
 **/
@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String returnId(String id){
        return "线程池："+Thread.currentThread().getName()+" returnId,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }


    public String returnIdTimeout(String id){
        int timeNum =3;
        try {

            TimeUnit.SECONDS.sleep(timeNum);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" returnId,id:"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时:"+timeNum+"秒";
    }
}
