package com.rc.m2oo2m.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Student
 * @Description TODO
 * @Author liux
 * @Date 19-4-5 上午11:59
 * @Version 1.0
 */
public class Student implements Serializable {
    private Integer sid;
    private String sname;
    private String ssex;

    private Grade grade;

    public Student() {
    }

    public Student(String sname, String ssex) {
        this.sname = sname;
        this.ssex = ssex;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid.equals(student.sid) &&
                sname.equals(student.sname) &&
                ssex.equals(student.ssex) &&
                grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, ssex, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", grade=" + grade +
                '}';
    }
}