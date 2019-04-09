package com.rc.annotation.relation.mtm_fk;

import javax.persistence.*;

/**
 * @ClassName Teacher
 * @Description 教师类
 * @Author liux
 * @Date 19-4-9 下午7:54
 * @Version 1.0
 */
@Entity
@Table(name="t_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
