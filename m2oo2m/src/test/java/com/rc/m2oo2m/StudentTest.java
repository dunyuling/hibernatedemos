package com.rc.m2oo2m;

import com.rc.m2oo2m.entity.Grade;
import com.rc.m2oo2m.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @ClassName StudentTest
 * @Description TODO
 * @Author liux
 * @Date 19-4-5 下午12:15
 * @Version 1.0
 */
public class StudentTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }


    /*
     * @Author liux
     * @Description 从班级角度添加
     * @Date 19-4-5 下午1:29
     * @param 
     * @return void
     **/
    @Test
    public void testAddFromGrade() {
        Grade grade = new Grade("grade1", "gdesc1");
        session.save(grade);

        Student student1 = new Student("zhangsan", "男");
        grade.getStudentSet().add(student1);
//        session.save(student1);

        Student student2 = new Student("lisi", "女");
        grade.getStudentSet().add(student2);
//        session.save(student2);

        //TODO 虽然可以通过Grade级联保存Student，个人认为不是最佳实践
    }

    /*
     * @Author liux
     * @Description 从学生角度添加
     * @Date 19-4-5 下午1:32
     * @param 
     * @return void
     **/
    @Test
    public void testAddFromStudent() {
        Grade grade = new Grade("grade1", "gdesc1");
        //TODO 下面这行可以注释掉，通过Student 级联保存Grade
//        session.save(grade);

        Student student1 = new Student("zhangsan", "unknown");
        student1.setGrade(grade);
        session.save(student1);

        Student student2 = new Student("lisi", "女");
        student2.setGrade(grade);
        session.save(student2);
    }

    /*
     * @Author liux
     * @Description 从班级角度查询,可以同时测试懒加载
     * @Date 19-4-5 下午4:34
     * @param 
     * @return void
     **/
    @Test
    public void testGetFromGrade() {
        Grade grade = session.get(Grade.class, 2);
        System.out.println(grade);

        grade.getStudentSet().forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 从学生角度查询
     * @Date 19-4-5 下午4:34
     * @param
     * @return void
     **/
    @Test
    public void testGetFromStudent() {
        Student student = session.get(Student.class, 1);
        System.out.println(student);

        System.out.println(student.getGrade().getClass().getName());
        System.out.println(student.getGrade());
    }

    /*
     * @Author liux
     * @Description 从班级角度修改
     * @Date 19-4-5 下午1:59
     * @param 
     * @return void
     **/
    @Test
    public void updateStudentFromGrade() {
        testAddFromStudent();

        System.out.println("------------");

        Grade grade = new Grade("grade2","gdesc2");
        Student student = session.get(Student.class, 1);
        grade.getStudentSet().add(student);
        session.save(grade);
    }


    /*
     * @Author liux
     * @Description 从学生角度修改
     * @Date 19-4-5 下午1:59
     * @param 
     * @return void
     **/
    @Test
    public void updateStudentFromStudent() {
        testAddFromStudent();

        System.out.println("------------");

        Grade grade = new Grade("grade2","gdesc2");
        Student student = session.get(Student.class, 1);

        session.save(grade);

        student.setGrade(grade);
        session.save(student);
    }

    @Test
    public void delete() {
//        session.delete(session.get(Student.class, 1));
//        session.delete(session.get(Student.class, 2));

        session.delete(session.get(Grade.class,2));
    }

    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
