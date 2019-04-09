package com.rc.annotation.clazz;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @ClassName User
 * @Description 用户类
 * @Author liux
 * @Date 19-4-9 下午12:08
 * @Version 1.0
 */
@Entity
@Table(name="t_user",schema = "hibernate_annotation")
public class User  {

    @EmbeddedId
    private UserPK uid;

    private String uname;

    @Transient
    private String gender;

    public User() {
    }

    public User(UserPK uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public UserPK getUid() {
        return uid;
    }

    public void setUid(UserPK uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
