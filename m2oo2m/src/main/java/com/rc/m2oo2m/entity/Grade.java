package com.rc.m2oo2m.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName Grade
 * @Description 班级类
 * @Author liux
 * @Date 19-4-5 上午11:59
 * @Version 1.0
 */
public class Grade implements Serializable {
    private Integer gid;
    private String gname;
    private String gdesc;
    private Set<Student> studentSet = new HashSet<>();

    public Grade() {
    }

    public Grade(String gname, String gdesc) {
        this.gname = gname;
        this.gdesc = gdesc;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(gid, grade.gid) &&
                Objects.equals(gname, grade.gname) &&
                Objects.equals(gdesc, grade.gdesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, gname, gdesc);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gdesc='" + gdesc + '\'' +
                '}';
    }
}
