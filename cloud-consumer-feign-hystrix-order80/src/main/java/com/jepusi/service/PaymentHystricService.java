package com.jepusi.service;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystricService {
    @GetMapping(value = "/provider/hystrix/paymentOK/{id}")
    public String hystrixPaymentOk(@PathVariable("id") long id);
    @GetMapping(value = "/provider/hystrix/paymentTimeout/{id}")
    public String hystrixPaymentTimeout(@PathVariable("id") long id);
}
