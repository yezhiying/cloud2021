package com.zhaoqingwang.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/16 20:33
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        /**
         * 定义为随机
         */
        return new RandomRule();
    }
}
