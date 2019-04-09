package com.rc.annotation.clazz;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author liux
 * @Date 19-4-9 上午9:49
 * @Version 1.0
 */
//@Entity(name = "student")
@Entity
@Table(name = "t_student", schema = "hibernate_annotation")//schema:对应数据库名称，此处不起作用
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键策略为auto increment
    private int sid;//学号
    private String sname;//姓名
    private String gender;//性别
    private Date birthday;//出生日期
    private String major;//专业
    @Embedded
    private Address address;//地址

    public Student() {
    }

    public Student(String sname, String gender, Date birthday, String major, Address address) {
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
