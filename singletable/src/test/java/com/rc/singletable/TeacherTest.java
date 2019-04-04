package com.rc.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/*
 * @ClassName StudentTest
 * @Description hibernate CRUD 基本操作流程，此处只有C.
 * @Author liux
 * @Date 19-4-4 下午12:44
 * @Version 1.0
 */
public class TeacherTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建会话工厂对象
        //4.35之后的方式
        sessionFactory = new Configuration().configure().buildSessionFactory();
        //创建会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
    }


    /*
     * @Author liux
     * @Description 保存老师
     * @Date 19-4-4 下午5:01
     * @param
     * @return void
     **/
    @Test
    public void testSaveTeacher() {

        Teacher teacher = new Teacher("ll", "男", new Date(), "china");
        session.save(teacher);
    }

    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}