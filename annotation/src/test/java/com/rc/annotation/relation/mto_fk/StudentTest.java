package com.rc.annotation.relation.mto_fk;

import com.rc.annotation.BaseTest;
import com.rc.annotation.relation.mto_fk.ClassRoom;
import com.rc.annotation.relation.mto_fk.Student;
import org.junit.Test;

/**
 * @ClassName StudentTest
 * @Description 多对一单向外键测试
 * @Author liux
 * @Date 19-4-9 下午4:17
 * @Version 1.0
 */
public class StudentTest extends BaseTest {

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

        Student student1 = new Student("aa","男", classRoom);
        Student student2 = new Student("bb","男", classRoom);
        session.save(student1);
        session.save(student2);
    }
}
