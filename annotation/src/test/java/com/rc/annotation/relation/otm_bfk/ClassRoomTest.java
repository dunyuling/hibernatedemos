package com.rc.annotation.relation.otm_bfk;

import com.rc.annotation.BaseTest;
import org.junit.Test;

import java.util.Set;

/**
 * @ClassName ClassRoomTest
 * @Description 一对多双向外键测试
 * @Author liux
 * @Date 19-4-9 下午4:17
 * @Version 1.0
 */
public class ClassRoomTest extends BaseTest {

    /*
     * @Author liux
     * @Description 保存测试--以一方为主
     * @Date 19-4-9 下午6:20
     * @param
     * @return void
     **/
    @Test
    public void testSaveByClassRoom() {
        ClassRoom classRoom = new ClassRoom("c1");

        Student student1 = new Student("aa", "男");
        Student student2 = new Student("bb", "男");

        Set<Student> students = classRoom.getStudents();
        students.add(student1);
        students.add(student2);

        session.save(classRoom);
    }

    /*
     * @Author liux
     * @Description 保存测试--以多方为主
     * @Date 19-4-9 下午6:56
     * @param
     * @return void
     **/
    @Test
    public void testSaveByStudent() {
        ClassRoom classRoom = new ClassRoom("c1");

        Student student1 = new Student("aa", "男", classRoom);
        Student student2 = new Student("bb", "男", classRoom);

        session.save(student1);
        session.save(student2);
    }
}
