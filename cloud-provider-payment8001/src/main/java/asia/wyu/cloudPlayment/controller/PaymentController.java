package asia.wyu.cloudPlayment.controller;


import asia.wyu.cloudPlayment.service.PaymentService;
import com.jepusi.apiCommons.entities.CommonResult;
import com.jepusi.apiCommons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @class: asia.wyu.cloudPlayment.controller.PaymentController
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/10/29 17:46
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("**插入结果**"+result);
        if (result < 0) {
            return new CommonResult(404, "数据插入失败", null);
        } else {
            return new CommonResult(200,"数据插入成功",result);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**查询数据为：**"+payment);
        if (payment != null) {
            return new CommonResult(200,"查询数据成功",payment);
        }else {
            return new CommonResult(404,"查询数据失败",null);
        }

    }
}
