package com.rc.annotation.clazz;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @ClassName UserPK
 * @Description 用户主键类
 * @Author liux
 * @Date 19-4-9 下午12:10
 * @Version 1.0
 */
@Embeddable
public class UserPK implements Serializable {

    @Column(length = 18)
    private String cardId; //身份证号码
    @Column(length = 8)
    private String uid;//用户标号

    public UserPK() {
    }

    public UserPK(String cardId, String uid) {
        this.cardId = cardId;
        this.uid = uid;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
