package com.rc.hql;

import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName CustomerTest
 * @Description 客户类测试
 * @Author liux
 * @Date 19-4-7 下午6:37
 * @Version 1.0
 */
public class CustomerTest extends BaseTest {

    @Test
    public void testFrom() {
        String hql = "from Customer";

        Query<Customer> query = session.createQuery(hql);

        query.list().forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 获取独特的结果--distinct关键字
     * @Date 19-4-7 下午8:11
     * @param
     * @return void
     **/
    @Test
    public void testSelectDistinct() {
        String hql = "select distinct c.sex from Customer c";

        Query query = session.createQuery(hql);

        List<Object> objects = query.list();

        objects.forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 范围运算
     * @Date 19-4-7 下午10:12
     * @param
     * @return void
     **/
    @Test
    public void testWhereScope() {
//        String hql = "from Customer c where c.age not in (20,40)";
        String hql = "from Customer c where c.age not between 20 and 40";

        Query<Customer> query = session.createQuery(hql);

        List<Customer> list = query.list();

        list.forEach( customer -> System.out.println("name: " + customer.getName() + "\t age: " + customer.getAge()));
    }

    /*
     * @Author liux
     * @Description 字符串模式匹配
     * @Date 19-4-7 下午10:20
     * @param 
     * @return void
     **/
    @Test
    public void testWhereLike() {
//        String hql = "from Customer c where c.name like '张_'";
        String hql = "from Customer c where c.address like '%北京%'";

        Query<Customer> query = session.createQuery(hql);

        List<Customer> list = query.list();

        list.forEach( customer -> System.out.println("name: " + customer.getName() + "\t address: " + customer.getAddress()));
    }

    /*
     * @Author liux
     * @Description 查询单个对象(uniqueResult方法)
     * @Date 19-4-7 下午10:59
     * @param 
     * @return void
     **/
    @Test
    public void testWhereUnique() {
        String hql = "from Customer c where c.name ='张三'";

        Query<Customer> query = session.createQuery(hql);

        Customer customer = query.uniqueResult();

        System.out.println("name: " + customer.getName());
    }
}
