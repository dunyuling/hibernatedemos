from:https://www.imooc.com/learn/410
##HQL数据查询基础
    + 目标
        * 了解HQL定义以及HQL语句形式
        * 掌握Query对象的使用
        * 能够编写出符合数据查询要求的HQL语句 

##了解HQL
    + HQL定义
        * Hibernate Query Language 
        + 面向对象的查询语言
            HQL 映射配置的持久化类及其属性
            SQL 数据库表
        * HQL提供了丰富灵活的查询特性，Hibernate官方推荐查询方式    
    + HQL语句形式
        select... from... where... group by... having... order by...  
    + HQL注意问题
        * HQL是面向对象的查询语言，对Java类与属性大小写敏感
        * HQL对关键字不区分大小写

##准备查询
    + org.hibernate.query.Query接口
        * Query接口定义有执行查询的方法
            HQL语句--（hibernate）-->(解析HQL语句，配置信息)-->SQL语句
        * Query接口支持方法链编程风格，使得程序代码更为简介   
            查询参数动态设置 
    + Query实例对象的创建
        * Session.createQuery(hql)
    + 执行查询
        * Query::list()

##查询子句
    + 检索对象--from子句
        + from子句
            * HQL语句最简形式
            * from指定了HQL语句查询主题--持久化类及其属性
        + from子句中持久化类的引用
            * 不需要引入持久化类的全限定名，直接引入类名
            * auto-import(自动引入)缺省情况
        + 别名的使用
            * 为被查询类使用别名
            * 在HQL语句其它部分通过别名引用该类
            * 别名使用习惯   
         
    + 选择--select子句
        + 以Object[]形式返回选择的属性SellerTest::testSelectObjectArray(),SellerTest::testSelectObject()
            * select子句中未指定返回的数据类型，默认为Object[]
        + 以list形式返回选择的属性SellerTest::testSelectList()
            * select子句使用new list(List)指定
        + 以map形式返回选择的属性SellerTest::testSelectMap()
            * select子句使用new map(Map)指定
            * key值为索引值，字符串类型
        + 以自定义类型返回选择的属性SellerTest::testSelectSelf()
            * 持久化类中定义相应的构造器
            * select子句中调用定义的构造器
        * 获取独特的结果--distinct关键字CustomerTest::testSelectDistinct()
        
    + 限制--where子句
        + 比较运算CommodityTest::testWhereCompare()和CommodityTest::testWhereNull()
            * =,<>,<,>,>=,<=
            * null值判断--is [not] null
                x = null -->  x is null
                x <> null --> x is not null
        + 范围运算CustomerTest::testWhereScope()
            * [not] in(列表)
            * [not] between 值1 and 值2
        + 字符串模式匹配CustomerTest::testWhereLike()
            * like
            * 通配符 (%:任意个字符),(-:一个字符)
        * 逻辑运算CommodityTest::testWhereLogic()
            * and ,or , not
        + 集合运算OrderTest::testWhereSet()
            * is [not] empty 集合[不]为空，不包含任何元素
                empty -> exists
            * member of 元素属于集合
                member of -> in
        * 在HQL中使用+-×/运算符CommodityTest::testWhereOperation()
        + 查询单个对象(uniqueResult方法)CustomerTest::testWhereUnique()
            * Query接口uniqueResult方法 
            * where子句条件的设置
    + 排序--order by子句 CommodityTest::testOrderBy()