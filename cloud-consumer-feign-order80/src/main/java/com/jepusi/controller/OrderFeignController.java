package com.jepusi.controller;

import com.jepusi.apiCommons.entities.CommonResult;
import com.jepusi.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String feignTimeout() {
        return orderFeignService.paymentFeignTimeout();
    }
}
