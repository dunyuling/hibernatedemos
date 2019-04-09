package com.rc.annotation.relation.mtm_bfk;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
