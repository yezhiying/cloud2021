package com.zhaoqingwang.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author zhaoqingwang
 * @version 1.0
 * @date 2021/3/15 21:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

   private Long id;
   private String serial;


}
