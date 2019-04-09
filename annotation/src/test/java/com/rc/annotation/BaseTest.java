package com.rc.annotation;

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
 * @Date 19-4-9 下午4:06
 * @Version 1.0
 */
public class BaseTest {

    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;


    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @After
    public void tearDown() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}