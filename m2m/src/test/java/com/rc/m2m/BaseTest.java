package com.rc.m2m;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author liux
 * @Date 19-4-8 下午2:02
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
