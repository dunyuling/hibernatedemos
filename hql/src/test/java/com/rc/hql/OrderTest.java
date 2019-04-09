package com.rc.hql;

import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName OrderTest
 * @Description 订单类测试
 * @Author liux
 * @Date 19-4-7 下午10:32
 * @Version 1.0
 */
public class OrderTest extends BaseTest {


    /*
     * @Author liux
     * @Description 集合运算
     * @Date 19-4-7 下午10:37
     * @param 
     * @return void
     **/
    @Test
    public void testWhereSet() {
        String hql = "from Order o where o.orderItems is not empty";

        Query<Order> query = session.createQuery(hql);

        List<Order> list = query.list();
        System.out.println("size: " + list.size() );

        list.forEach(order -> System.out.println("customer name: " + order.getCustomer().getName() + "\t amount: " + order.getAmount() + "\t tradedate: " + order.getTradeDate()));
    }

}
