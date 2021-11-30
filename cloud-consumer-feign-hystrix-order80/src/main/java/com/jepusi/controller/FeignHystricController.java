package com.jepusi.controller;

import com.jepusi.service.PaymentHystricService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
//@DefaultProperties(defaultFallback = "paymentHystrixGlobalFallbackMethod")
public class FeignHystricController {
    @Resource
    private PaymentHystricService paymentHystricService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystric/paymentOk/{id}")
    public String paymentOk(@PathVariable("id") long id) {
        String result = paymentHystricService.hystrixPaymentOk(id);
        log.info("**************result: "+result);
        return result;
    }

   /* @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @GetMapping("/payment/hystric/paymentTimeout/{id}")
    //@HystrixCommand
    public String paymentTimeout(@PathVariable("id") long id) {
        String result = paymentHystricService.hystrixPaymentTimeout(id);
        log.info("************result: "+result);
        return result;
    }

   /* public String paymentTimeoutHandler(@PathVariable("id") long id) {
        return "我是消费段80，服务超时请稍等10分钟，哈哈哈哈哈 id="+id;
    }*/

    /*public String paymentHystrixGlobalFallbackMethod() {
        return "全局方法调用，请求服务已超时******";
    }*/
}
