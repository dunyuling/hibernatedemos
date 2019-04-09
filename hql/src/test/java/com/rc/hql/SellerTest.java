package com.rc.hql;

import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SellerTest
 * @Description 商家类测试
 * @Author liux
 * @Date 19-4-7 下午5:43
 * @Version 1.0
 */
public class SellerTest extends BaseTest {


    /*
     * @Author liux
     * @Description 直接使用引用
     * @Date 19-4-7 下午6:59
     * @param
     * @return void
     **/
    @Test
    public void testFrom() {
        String hql = "from Seller";

        Query<Seller> query = session.createQuery(hql);

        query.list().forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 使用全限定名：package/clazz
     * @Date 19-4-7 下午6:59
     * @param
     * @return void
     **/
    @Test
    public void testFrom2() {
        String hql = "from com.rc.hql.Seller";

        Query<Seller> query = session.createQuery(hql);

        query.list().forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 使用别名
     * @Date 19-4-7 下午7:00
     * @param
     * @return void
     **/
    @Test
    public void testFromAlias() {
        String hql = "from Seller seller";

        Query<Seller> query = session.createQuery(hql);

        query.list().forEach(System.out::println);
    }


    /*
     * @Author liux
     * @Description 多个属性以Object[]形式返回选择的属性
     * @Date 19-4-7 下午7:19
     * @param
     * @return void
     **/
    @Test
    public void testSelectObjectArray() {
        String hql = "select s.name, s.tel, s.address , s.star from Seller s";

        Query query = session.createQuery(hql);

        List<Object[]> list = query.list();
        for (Object[] obj : list) {
            System.out.println("name: " + obj[0] + "\ttel: " + obj[1] + "\taddress:" + obj[2] + "\tstar:" + obj[3]);
        }
    }

    /*
     * @Author liux
     * @Description 单个属性以Object形式返回选择的属性
     * @Date 19-4-7 下午7:26
     * @param
     * @return void
     **/
    @Test
    public void testSelectObject() {
        String hql = "select s.name from Seller s";

        Query query = session.createQuery(hql);

        List<Object> list = query.list();
        for (Object obj : list) {
            System.out.println("name: " + obj);
        }
    }

    /*
     * @Author liux
     * @Description 以list形式返回选择的属性
     * @Date 19-4-7 下午7:32
     * @param
     * @return void
     **/
    @Test
    public void testSelectList() {
        String hql = "select new List(s.name, s.tel, s.address , s.star) from Seller s";

        Query query = session.createQuery(hql);

        List<List> lists = query.list();
        for (List list : lists) {
            System.out.println("name: " + list.get(0) + "\ttel: " + list.get(1) + "\taddress:" + list.get(2) + "\tstar:" + list.get(3));
        }
    }


    /*
     * @Author liux
     * @Description 以map形式返回选择的属性
     * @Date 19-4-7 下午7:56
     * @param
     * @return void
     **/
    @Test
    public void testSelectMap() {
        String hql = "select new map(s.name, s.tel, s.address , s.star) from Seller s";

        Query query = session.createQuery(hql);

        List<Map> maps = query.list();
        for (Map map : maps) {
            System.out.println("name: " + map.get("0") + "\ttel: " + map.get("1") + "\taddress:" + map.get("2") + "\tstar:" + map.get("3"));
        }
    }

    /*
     * @Author liux
     * @Description 以map形式返回选择的属性,设置key的别名
     * @Date 19-4-7 下午8:00
     * @param
     * @return void
     **/
    @Test
    public void testSelectMapKeyAlias() {
        String hql = "select new map(s.name as name, s.tel as tel, s.address as address, s.star as star) from Seller s";

        Query query = session.createQuery(hql);

        List<Map> maps = query.list();
        for (Map map : maps) {
            System.out.println("name: " + map.get("name") + "\ttel: " + map.get("tel")
                    + "\taddress:" + map.get("address") + "\tstar:" + map.get("star"));
        }
    }

    /*
     * @Author liux
     * @Description 以自定义类型返回选择的属性
     * @Date 19-4-7 下午8:04
     * @param
     * @return void
     **/
    @Test
    public void testSelectSelf() {
        String hql = "select new Seller (s.name , s.tel , s.address , s.star) from Seller s";

        Query query = session.createQuery(hql);

        List<Seller> sellers = query.list();
        for (Seller seller : sellers) {
            System.out.println("name: " + seller.getName() + "\ttel: " + seller.getTel()
                    + "\taddress:" + seller.getAddress() + "\tstar:" + seller.getStar());
        }
    }



}
