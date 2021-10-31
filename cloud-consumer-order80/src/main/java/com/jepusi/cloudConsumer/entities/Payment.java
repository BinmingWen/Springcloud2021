package com.jepusi.cloudConsumer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @class: asia.wyu.cloudPlayment.entities.Payment
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/9/3 18:09
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
