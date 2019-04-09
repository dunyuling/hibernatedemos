package com.rc.annotation.relation.otm_fk;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ClassRoom
 * @Description 班级类
 * @Author liux
 * @Date 19-4-9 下午6:09
 * @Version 1.0
 */
@Entity
@Table(name="t_classroom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;//班级编号

    private String cname;//班级名称

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="cid")
    private Set<Student> students = new HashSet<>();

    public ClassRoom() {
    }

    public ClassRoom(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
