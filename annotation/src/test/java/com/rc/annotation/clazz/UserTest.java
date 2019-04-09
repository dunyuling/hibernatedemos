package com.rc.annotation.clazz;

import com.rc.annotation.BaseTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName UserTest
 * @Description 用户类--测试嵌入式主键类实现复合主键
 * @Author liux
 * @Date 19-4-9 上午9:57
 * @Version 1.0
 */
public class UserTest extends BaseTest {

    @Test
    public void testInsert() {
        User user = new User(new UserPK("10010019100101xxxx","u0001002"),"xyz");
        session.save(user);
    }
}
