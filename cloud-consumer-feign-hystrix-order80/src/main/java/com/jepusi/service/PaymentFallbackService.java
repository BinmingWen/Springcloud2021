package com.jepusi.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystricService{
    @Override
    public String hystrixPaymentOk(long id) {
        return "*******paymentFallback for hystrixPaymentOk ";
    }

    @Override
    public String hystrixPaymentTimeout(long id) {
        return "******paymentFallback for hystrixPaymentTimeout ";
    }
}
