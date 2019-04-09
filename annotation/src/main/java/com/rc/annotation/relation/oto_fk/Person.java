package com.rc.annotation.relation.oto_fk;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Person
 * @Description 公民类
 * @Author liux
 * @Date 19-4-9 上午9:49
 * @Version 1.0
 */
//@Entity(name = "student")
@Entity
@Table(name = "t_person", schema = "hibernate_annotation")//schema:对应数据库名称，此处不起作用
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键策略为auto increment
    private int id;//学号
    private String name;//姓名
    private String gender;//性别
    private Date birthday;//出生日期

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="no",unique = true,referencedColumnName = "no")
    private IdentificationCard identificationCard;//身份证


    public Person() {
    }

    public Person(String name, String gender, Date birthday, IdentificationCard identificationCard) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.identificationCard = identificationCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int pid) {
        this.id = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String pname) {
        this.name = pname;
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

    public IdentificationCard getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(IdentificationCard identificationCard) {
        this.identificationCard = identificationCard;
    }
}