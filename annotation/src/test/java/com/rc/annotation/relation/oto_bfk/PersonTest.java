package com.rc.annotation.relation.oto_bfk;

import com.rc.annotation.BaseTest;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName PersonTest
 * @Description 一对一双向外键测试
 * @Author liux
 * @Date 19-4-9 下午4:17
 * @Version 1.0
 */
public class PersonTest extends BaseTest {

    /*
     * @Author liux
     * @Description 测试保存，先保存被空方IdentificationCard,后保存主控方
     * @Date 19-4-9 下午5:12
     * @param 
     * @return void
     **/
    @Test
    public void testSave() {
        IdentificationCard identificationCard = new IdentificationCard("10010019100101xxxx");
        session.save(identificationCard);
        Person person = new Person("xyz","男",new Date(), identificationCard);
        session.save(person);
    }

    /*
     * @Author liux
     * @Description 查询，以IdentificationCard为主
     * @Date 19-4-9 下午5:15
     * @param 
     * @return void
     **/
    @Test
    public void testGetByIdCard() {
        IdentificationCard identificationCard = session.get(IdentificationCard.class,1);
        System.out.println(identificationCard);
        System.out.println(identificationCard.getPerson());
    }

    /*
     * @Author liux
     * @Description 查询，以Person为主
     * @Date 19-4-9 下午5:16
     * @param 
     * @return void
     **/
    @Test
    public void testGetByPerson() {
        Person person = session.get(Person.class, 1);
        System.out.println(person);
        System.out.println(person.getIdentificationCard());
    }
}
