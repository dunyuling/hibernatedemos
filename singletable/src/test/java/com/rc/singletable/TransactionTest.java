package com.rc.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName TransactionTest
 * @Description hibernate 事务测试
 * @Author liux
 * @Date 19-4-4 下午5:42
 * @Version 1.0
 */
public class TransactionTest {

    /*
     * @Author liux
     * @Description 在事务中提交session动作
     * @Date 19-4-4 下午5:44
     * @param 
     * @return void
     **/
    @Test
    public void testSaveInTransaction() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student("ll", "男", new Date(), new Address());
        session.save(student);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    /*
     * @Author liux
     * @Description 在事务外提交session动作
     *              TODO 关闭事务模式的情况下，测试不能成功，应该是已经不再支持自动提交模式
     * @Date 19-4-4 下午5:45
     * @param 
     * @return void
     **/
    @Test
    public void testSaveOutOfTransaction() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = new Student("ll", "男", new Date(), new Address());
        session.doWork(connection -> connection.setAutoCommit(true));
        session.save(student);
        System.out.println("flushMode: " + session.getFlushMode().name() + ": " + session.getHibernateFlushMode().name());
        session.flush();

        session.close();
        sessionFactory.close();
    }
}
