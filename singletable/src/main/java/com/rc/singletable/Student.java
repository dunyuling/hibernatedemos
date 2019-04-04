package com.rc.singletable;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author liux
 * @Date 19-4-4 下午12:14
 * @Version 1.0
 */
public class Student implements Serializable {

    private String sid;    //学号
    private String sname;//姓名
    private String gender;//性别
    private Date birthday;//生日
//    private String address;//地址
    private Blob picture;//照片
    private byte[] favor;//爱好,仅做功能测试用

    private Address address;

    public Student() {
    }

    public Student(String sname, String gender, Date birthday, Address address) {
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public byte[] getFavor() {
        return favor;
    }

    public void setFavor(byte[] favor) {
        this.favor = favor;
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
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", picutre=" + picture +
                ", favor=" + Arrays.toString(favor) +
                '}';
    }
}