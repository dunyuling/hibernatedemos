package com.rc.annotation.relation.mtm_fk;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author liux
 * @Date 19-4-9 下午6:08
 * @Version 1.0
 */
@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid; //学号
    private String sname;//姓名
    private String ssex;//性别

    @ManyToMany
    @JoinTable(name="t_teacher_student",
            joinColumns={@JoinColumn(name="sid")},
            inverseJoinColumns={@JoinColumn(name="tid")}
    )
    private Set<Teacher> teachers = new HashSet<>();


    public Student() {
    }

    public Student(String sname, String ssex) {
        this.sname = sname;
        this.ssex = ssex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
