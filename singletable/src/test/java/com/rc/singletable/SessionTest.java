package com.rc.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName SessionTest
 * @Description hibernate session测试
 * @Author liux
 * @Date 19-4-4 下午5:40
 * @Version 1.0
 */
public class SessionTest {

    /*
     * @Author liux
     * @Description 通过 openSession() 获取session
     * @Date 19-4-4 下午5:51
     * @param
     * @return void
     **/
    @Test
    public void testOpenSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        if (session != null) {
            System.out.println("session创建成功");
//            System.out.println(sessionFactory.openSession().hashCode() + "\t" + sessionFactory.openSession().hashCode()
//                    + "\t" + sessionFactory.getCurrentSession().hashCode() + "\t" + sessionFactory.getCurrentSession().hashCode());
            session.close();
        } else {
            System.out.println("session创建失败");
        }
        sessionFactory.close();
    }

    /*
     * @Author liux
     * @Description 每次通过 openSession() 获取的session对象不同
     * @Date 19-4-4 下午6:14
     * @param 
     * @return void
     **/
    @Test
    public void testOpenSessionNotEqual() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();

        System.out.println(session1 == session2);
        session1.close();
        session2.close();
        sessionFactory.close();
    }


    /*
     * @Author liux
     * @Description 通过 getCurrentSession() 获取session
     * @Date 19-4-4 下午5:51
     * @param
     * @return void
     **/
    @Test
    public void testGetCurrentSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        if (session != null) {
            System.out.println("session创建成功 " + session.hashCode());//859617558

            session.close();
        } else {
            System.out.println("session创建失败");
        }
        sessionFactory.close();

    }

    /*
     * @Author liux
     * @Description 每次通过 getCurrentSession() 获取的session对象相同
     * @Date 19-4-4 下午6:15
     * @param
     * @return void
     **/
    @Test
    public void testGetCurrentSessionEqual() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();

        System.out.println(session1 == session2);
        session1.close();
        session2.close();
        sessionFactory.close();
    }

    /*
     * @Author liux
     * @Description openSession每次打开一个新的数据库连接，多次不关闭会导致连接池溢出
     * @Date 19-4-4 下午6:17
     * @param 
     * @return void
     **/
    @Test
    public void testSaveStudentWithOpenSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();
        Student student = new Student("a","男",new Date(),new Address());
        session1.save(student);
        transaction.commit();
        session1.doWork(connection -> System.out.println(connection.hashCode()));

        System.out.println("------------");

        session1 = sessionFactory.openSession();
        transaction = session1.beginTransaction();
        student = new Student("a","男",new Date(),new Address());
        session1.save(student);
        transaction.commit();
        session1.doWork(connection -> System.out.println(connection.hashCode()));

        sessionFactory.close();
    }

    /*
     * @Author liux
     * @Description getCurrentSession多次共用一个数据库连接
     * @Date 19-4-4 下午6:17
     * @param
     * @return void
     **/
    @Test
    public void testSaveStudentWithGetCurrentSession() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.getCurrentSession();
        Transaction transaction = session1.beginTransaction();
        Student student = new Student("a","男",new Date(),new Address());
        session1.save(student);
        transaction.commit();
        //java.lang.IllegalStateException: org.hibernate.resource.jdbc.internal.LogicalConnectionManagedImpl@21a66d45 is closed
        //上述异常证明连接已经关闭
        session1.doWork(connection -> System.out.println(connection.hashCode()));

        System.out.println("------------");

        session1 = sessionFactory.getCurrentSession();
        transaction = session1.beginTransaction();
        student = new Student("a","男",new Date(),new Address());
        session1.save(student);
        transaction.commit();
        session1.doWork(connection -> System.out.println(connection.hashCode()));

        sessionFactory.close();
    }
}
