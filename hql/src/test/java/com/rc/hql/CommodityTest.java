package com.rc.hql;

import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName CommodityTest
 * @Description 货物类测试
 * @Author liux
 * @Date 19-4-7 下午6:44
 * @Version 1.0
 */
public class CommodityTest extends BaseTest {

    @Test
    public void testFrom() {
        String hql = "from Commodity ";

        Query<Commodity> query = session.createQuery(hql);

        query.list().forEach(System.out::println);
    }

    /*
     * @Author liux
     * @Description 比较运算
     * @Date 19-4-7 下午9:59
     * @param
     * @return void
     **/
    @Test
    public void testWhereCompare() {
        String hql = "from Commodity c where c.price > 400";

        Query<Commodity> query = session.createQuery(hql);

        List<Commodity> list = query.list();

        list.forEach(commodity -> System.out.println("name: " + commodity.getName() + "\t price: " + commodity.getPrice()));
    }

    /*
     * @Author liux
     * @Description null值判断
     * @Date 19-4-7 下午10:04
     * @param
     * @return void
     **/
    @Test
    public void testWhereNull() {
        String hql = "from Commodity c where c.description <> null";

        Query<Commodity> query = session.createQuery(hql);

        List<Commodity> list = query.list();

        list.forEach(commodity -> System.out.println("name: " + commodity.getName() + "\t description: " + commodity.getDescription()));
    }

    /*
     * @Author liux
     * @Description 逻辑运算
     * @Date 19-4-7 下午10:24
     * @param
     * @return void
     **/
    @Test
    public void testWhereLogic() {
//        String hql = "from Commodity c where c.price between 100 and 5000 and c.category like '%电脑%'";
        String hql = "from Commodity c where c.price between 100 and 5000 or c.category like '%电脑%'";

        Query<Commodity> query = session.createQuery(hql);

        List<Commodity> list = query.list();

        list.forEach(commodity -> System.out.println("name: " + commodity.getName() + "\t price: " + commodity.getPrice() + "\t category: " + commodity.getCategory()));
    }

    /*
     * @Author liux
     * @Description 在HQL中使用+-×/运算符
     * @Date 19-4-7 下午10:56
     * @param 
     * @return void
     **/
    @Test
    public void testWhereOperation() {
        String hql = "from Commodity c where c.price * 5 > 3000";

        Query<Commodity> query = session.createQuery(hql);

        List<Commodity> list = query.list();

        list.forEach(commodity -> System.out.println("name: " + commodity.getName() + "\t price: " + commodity.getPrice()));
    }

    /*
     * @Author liux
     * @Description  排序--order by子句
     * @Date 19-4-7 下午11:09
     * @param
     * @return void
     **/
    @Test
    public void testOrderBy() {
        String hql = "from Commodity c order by c.seller.id asc , c.price desc, c.name asc";

        Query<Commodity> query = session.createQuery(hql);

        List<Commodity> list = query.list();

        list.forEach(commodity -> System.out.println("seller.id " + commodity.getSeller().getId() + "\tname: " + commodity.getName() + "\t price: " + commodity.getPrice()));
    }
}
