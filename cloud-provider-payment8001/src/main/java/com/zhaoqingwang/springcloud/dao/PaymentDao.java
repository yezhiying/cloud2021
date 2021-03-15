package com.zhaoqingwang.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaoqingwang.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/15 21:29
 **/
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
}
