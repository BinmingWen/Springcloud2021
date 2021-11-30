package com.jepusi.controller;

import com.jepusi.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/provider/hystrix/paymentOK/{id}")
    public String hystrixPaymentOk(@PathVariable("id") long id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("**************result = "+result);
        return serverPort+" "+result;
    }

    @GetMapping(value = "/provider/hystrix/paymentTimeout/{id}")
    public String hystrixPaymentTimeout(@PathVariable("id") long id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("************result = "+result);
        return serverPort+" "+result;
    }

    @GetMapping(value = "/provider/hystrix/circuit/{id}")
    public String hystrixCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.hystrixCircuitBreaker(id);
        log.info("************result******"+result);
        return serverPort+" "+result;

    }
}
