package com.rc.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * @ClassName BaseTest
 * @Description 测试基类
 * @Author liux
 * @Date 19-4-7 下午5:43
 * @Version 1.0
 */
public class BaseTest {

    SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        System.out.println("sessionFactory: " + sessionFactory.hashCode());
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @After
    public void tearDown() {
        transaction.commit();
        session.close();
    }
}