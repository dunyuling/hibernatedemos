package com.rc.annotation.clazz;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Teacher
 * @Description 老师类
 * @Author liux
 * @Date 19-4-9 上午9:49
 * @Version 1.0
 */
//@Entity(name = "student")
@Entity
@Table(name = "t_teacher", schema = "hibernate_annotation")//schema:对应数据库名称，此处不起作用
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator = "tid")
    @GenericGenerator(name = "tid", strategy = "assigned")//手工分配id
    private String tid;//职工号
    private String tname;//姓名

    public Teacher() {
    }

    public Teacher(String tname) {
        this.tname = tname;
    }

    public Teacher(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
