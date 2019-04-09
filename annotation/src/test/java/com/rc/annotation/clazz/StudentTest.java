package com.rc.annotation.clazz;

import com.rc.annotation.BaseTest;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName StudentTest
 * @Description 学生测试类
 * @Author liux
 * @Date 19-4-9 上午9:57
 * @Version 1.0
 */
public class StudentTest extends BaseTest {

    /*
     * @Author liux
     * @Description 测试保存
     * @Date 19-4-9 下午4:09
     * @param 
     * @return void
     **/
    @Test
    public void testInsert() {
        Student student1 = new Student("s1", "男", new Date(), "computer", new Address("100100", "北京", "138"));
        Student student2 = new Student("s2", "男", new Date(), "philosophy", new Address("100101", "郑州", "139"));
        session.save(student1);
        session.save(student2);

        Teacher teacher = new Teacher("t001", "t1");
        session.save(teacher);
    }
}
