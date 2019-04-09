package com.rc.annotation.relation.oto_fk;

import com.rc.annotation.BaseTest;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName PersonTest
 * @Description 一对一单向外键测试
 * @Author liux
 * @Date 19-4-9 下午4:17
 * @Version 1.0
 */
public class PersonTest extends BaseTest {

    @Test
    public void test() {
        IdentificationCard identificationCard = new IdentificationCard("10010019100102xxxx");
        session.save(identificationCard);
        Person person = new Person("xyk","男",new Date(), identificationCard);
        session.save(person);
    }
}
