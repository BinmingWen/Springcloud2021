package asia.wyu.cloudPlayment.dao;

import asia.wyu.cloudPlayment.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @class: asia.wyu.cloudPlayment.dao.PaymentDao
 * @description:
 * @author: 温明彬
 * @company: 广州博瑞信息技术股份有限公司
 * @create: 2021/10/29 17:35
 */


public interface PaymentDao {

    int create(@Param("serial") String serial);

    Payment getPaymentById(@Param("id") Long id);
}
