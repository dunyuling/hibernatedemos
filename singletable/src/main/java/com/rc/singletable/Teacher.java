package com.rc.singletable;

import java.util.Date;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author liux
 * @Date 19-4-4 下午6:45
 * @Version 1.0
 */
public class Teacher {

    private int tid;    //职工编号
    private String tname;//姓名
    private String gender;//性别
    private Date birthday;//生日
    private String address;//地址

    public Teacher() {
    }

    public Teacher(String tname, String gender, Date birthday, String address) {
        this.tname = tname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public Teacher(int tid, String tname, String gender, Date birthday, String address) {
        this.tid = tid;
        this.tname = tname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
