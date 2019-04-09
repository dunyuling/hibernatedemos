package com.rc.annotation.relation.otm_fk;

import com.rc.annotation.BaseTest;
import org.junit.Test;

import java.util.Set;

/**
 * @ClassName ClassRoomTest
 * @Description 一对多单向外键测试
 * @Author liux
 * @Date 19-4-9 下午4:17
 * @Version 1.0
 */
public class ClassRoomTest extends BaseTest {

    /*
     * @Author liux
     * @Description 保存测试
     * @Date 19-4-9 下午6:20
     * @param 
     * @return void
     **/
    @Test
    public void testSave() {
        ClassRoom classRoom = new ClassRoom("c1");

        Student student1 = new Student("aa","男");
        Student student2 = new Student("bb","男");

        Set<Student> students = classRoom.getStudents();
        students.add(student1);
        students.add(student2);

        session.save(classRoom);
    }
}
