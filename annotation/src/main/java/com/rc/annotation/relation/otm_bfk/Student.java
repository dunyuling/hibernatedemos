package com.rc.annotation.relation.otm_bfk;

import javax.persistence.*;

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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String sname, String ssex) {
        this.sname = sname;
        this.ssex = ssex;
    }

    public Student(String sname, String ssex, ClassRoom classRoom) {

        this.sname = sname;
        this.ssex = ssex;
        this.classRoom = classRoom;
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

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
