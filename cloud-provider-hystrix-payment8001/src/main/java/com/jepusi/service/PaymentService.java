package com.jepusi.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfoOk(Long id) {
        return "线程池："+Thread.currentThread().getName()+"payment ok: "+id+"\t 哈哈";
    }

    @HystrixCommand(fallbackMethod = "hystrixPaymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfoTimeout(long id) {
        int timeNumber = 5;
        int  i = 1/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"payment timeout: "+id+"\t呜呜";
    }
    //处理方法
    public String hystrixPaymentTimeoutHandler(long id) {
        return "线程池："+Thread.currentThread().getName()+"系统繁忙，请稍后再试 id = "+id+"\t呜呜";
    }

    @HystrixCommand(fallbackMethod = "hystrixCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),    //开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间范围
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),   //失败次数
    })
    public String hystrixCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String s = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t 调用成功，流水号："+s;
    }

    public String hystrixCircuitBreakerHandler(@PathVariable("id") Integer id) {
        return "id 不能是负数，请稍后再试试 ~id="+id;
    }

}
