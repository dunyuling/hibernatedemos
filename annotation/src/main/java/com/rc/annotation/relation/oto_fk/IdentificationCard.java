package com.rc.annotation.relation.oto_fk;

import javax.persistence.*;

/**
 * @ClassName IdentificationCard
 * @Description 身份证
 * @Author liux
 * @Date 19-4-9 下午3:52
 * @Version 1.0
 */
@Entity
@Table(name="t_idcard", schema = "hibernate_annotation")
public class IdentificationCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 18)
    private String no;//身份证号码

    public IdentificationCard() {
    }

    public IdentificationCard(String pno) {
        this.no = pno;
    }

    public int getId() {
        return id;
    }

    public void setId(int pid) {
        this.id = pid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String pno) {
        this.no = pno;
    }
}
