package asia.wyu.cloudPlayment.service;

import asia.wyu.cloudPlayment.entities.Payment;

/**
 * @class: asia.wyu.cloudPlayment.service.PaymentService
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/10/29 17:40
 */


public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
