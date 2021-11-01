package asia.wyu.cloudPlayment.service.impl;

import asia.wyu.cloudPlayment.dao.PaymentDao;

import asia.wyu.cloudPlayment.service.PaymentService;
import com.jepusi.apiCommons.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @class: asia.wyu.cloudPlayment.service.impl.PaymentServiceImpl
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/10/29 17:44
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
