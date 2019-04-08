package com.rc.cache.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


/**
 * @ClassName CustomerTest
 * @Description TODO
 * @Author liux
 * @Date 19-4-8 下午3:56
 * @Version 1.0
 */
public class CustomerTest {

    /*
     * @Author liux
     * @Description 一级，同一个session对于同一个实体只查询一次数据库
     * @Date 19-4-8 下午4:00
     * @param 
     * @return void
     **/
    @Test
    public void testFirstLevelSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,1L);
        System.out.println(session.hashCode());
        System.out.println(customer);

        //TODO 清除之后，需要再次查询数据库
//        session.evict(customer);
//        session.clear();

        session = sessionFactory.getCurrentSession();
        customer = session.get(Customer.class,1L);
        System.out.println(session.hashCode());
        System.out.println(customer);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /*
     * @Author liux
     * @Description 一级，query.list()不做缓存,query.iterate()默认做缓存
     * @Date 19-4-8 下午4:17
     * @param
     * @return void
     **/
    @Test
    public void testFirstLevelSession2() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        customers.forEach(customer->System.out.println(customer.getName()));

        customers = query.list();
        customers.forEach(customer->System.out.println(customer.getName()));

        System.out.println("--------------");
        Iterator<Customer> iterator = query.iterate();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /*
     * @Author liux
     * @Description 二级缓存，不同session对于同一个实体查询多次数据库
     * @Date 19-4-8 下午4:02
     * @param 
     * @return void
     **/
    @Test
    public void testSecondLevelSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,1L);
        System.out.println(session.hashCode());
        System.out.println(customer);


        session = sessionFactory.openSession();
        customer = session.get(Customer.class,1L);
        System.out.println(session.hashCode());
        System.out.println(customer);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /*
     * @Author liux
     * @Description 一级缓存保存的是内存对象的引用，二级缓存中数据散装，需重新封装新的对象，所以两个内存地址不同
     * @Date 19-4-8 下午4:25
     * @param 
     * @return void
     **/
    @Test
    public void testMixLevelSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,1L);
        System.out.println("session: " + session.hashCode() + " \t customer: " + customer.hashCode());

        customer = session.get(Customer.class,1L);
        System.out.println("session: " + session.hashCode() + " \t customer: " + customer.hashCode());


        session = sessionFactory.openSession();
        customer = session.get(Customer.class,1L);
        System.out.println("session: " + session.hashCode() + " \t customer: " + customer.hashCode());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
