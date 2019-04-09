package com.rc.annotation.relation.mtm_bfk;

import com.rc.annotation.BaseTest;
import org.junit.Test;

/**
 * @ClassName StudentTest
 * @Description 多对多双向外键关联测试
 * @Author liux
 * @Date 19-4-9 下午8:16
 * @Version 1.0
 */
public class StudentTest extends BaseTest {

    /*
     * @Author liux
     * @Description 保存测试--Student方为主控方
     * @Date 19-4-9 下午8:21
     * @param 
     * @return void
     **/
    @Test
    public void testSaveByStudent() {
        Teacher teacher1 = new Teacher("t1");
        Teacher teacher2 = new Teacher("t2");
        Teacher teacher3 = new Teacher("t3");

        Student student1 = new Student("aa", "男");
        Student student2 = new Student("bb", "男");
        Student student3 = new Student("cc", "女");

        student1.getTeachers().add(teacher1);
        student1.getTeachers().add(teacher2);

        student2.getTeachers().add(teacher1);
        student2.getTeachers().add(teacher2);

        student3.getTeachers().add(teacher2);
        student3.getTeachers().add(teacher3);

        session.save(teacher1);
        session.save(teacher2);
        session.save(teacher3);

        session.save(student1);
        session.save(student2);
        session.save(student3);
    }
}
