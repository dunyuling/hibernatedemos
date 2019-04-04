package com.rc.singletable;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

/*
 * @ClassName StudentTest
 * @Description hibernate CRUD 基本操作流程，此处只有C.
 * @Author liux
 * @Date 19-4-4 下午12:44
 * @Version 1.0
 */
public class StudentTest {

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
     * @Description 保存学生
     * @Date 19-4-4 下午5:01
     * @param
     * @return void
     **/
    @Test
    public void testSaveStudent() {
        Student student = new Student("ll", "男", new Date(), new Address());
        session.save(student);
    }

    /*
     * @Author liux
     * @Description 获取学生-get
     * @Date 19-4-5 上午12:36
     * @param
     * @return void
     **/
    @Test
    public void testGetStudent() {
        //返回对象本身
        Student student = session.get(Student.class, "ff80818169e94a4f0169e94a51f90000");
        System.out.println("class name: " + student.getClass().getName());
//        System.out.println(student);
    }

    /*
     * @Author liux
     * @Description 获取学生-load
     * @Date 19-4-5 上午12:39
     * @param
     * @return void
     **/
    @Test
    public void testLoadStudent() {
        //返回代理对象
        Student student = session.load(Student.class, "ff80818169e94a4f0169e94a51f90000");
        System.out.println("class name: " + student.getClass().getName());
//        System.out.println(student);
    }

    /*
     * @Author liux
     * @Description 更新学生
     * @Date 19-4-5 上午12:35
     * @param
     * @return void
     **/
    @Test
    public void testUpdateStudent() {
        Student student = session.get(Student.class, "ff80818169e94a4f0169e94a51f90000");
        student.setGender("女");
    }


    /*
     * @Author liux
     * @Description 删除学生
     * @Date 19-4-5 上午12:42
     * @param
     * @return void
     **/
    @Test
    public void testDeleteStudent() {
        Student student = session.get(Student.class, "ff80818169e94a4f0169e94a51f90000");
        session.delete(student);
    }


    /*
     * @Author liux
     * @Description 保存学生，部分字段为二进制数据
     * @Date 19-4-4 下午11:46
     * @param
     * @return void
     **/
    @Test
    public void testWriteBlobAndByteArray() throws IOException {
        Student student = new Student("ll", "男", new Date(), new Address());
        //先获取照片文件
        File file = new File("/home/liux/engineer.png");
        InputStream inputStream = new FileInputStream(file);
        Blob image = Hibernate.getLobCreator(session).createBlob(inputStream, file.length());
        student.setPicture(image);

        student.setFavor(new String("篮球").getBytes());
        session.save(student);
    }

    /*
     * @Author liux
     * @Description 读取学生，部分字段为二进制数据
     *      TODO 当图片为142,373 字节时可以获得的图片可以正常显示,当图片为1,210,301 字节时，获取的图片无法正常显示
     * @Date 19-4-5 上午12:07
     * @param
     * @return void
     **/
    @Test
    public void testReadWithBlobAndByteArray() throws SQLException, IOException {
        Student student = session.get(Student.class, "ff80818169e916040169e916080d0000");
        System.out.println(new String(student.getFavor(), StandardCharsets.UTF_8));
        InputStream inputStream = student.getPicture().getBinaryStream();
        OutputStream outputStream = new FileOutputStream(new File("/home/liux/pic.jpeg"));
/*
        byte[] buffer = new byte[2048];
        int count;
        while ((count = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0 ,count);
        }*/
        byte[] buffer = new byte[inputStream.available()];
        outputStream.write(buffer);

        outputStream.close();
        inputStream.close();
    }


    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}