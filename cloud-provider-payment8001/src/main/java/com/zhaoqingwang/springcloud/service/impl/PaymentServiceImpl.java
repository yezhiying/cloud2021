package com.zhaoqingwang.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaoqingwang.springcloud.dao.PaymentDao;
import com.zhaoqingwang.cloud.entity.Payment;
import com.zhaoqingwang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/15 21:13
 **/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements PaymentService  {


}
