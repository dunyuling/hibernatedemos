## from:https://www.imooc.com/learn/396

##hibernate.cfg.xml常用配置
    * show_sql
    * format_sql
    * hbm2ddl.auto(create|update|create-drop|validate)
    * hibernate.dialect
    
##session简介
    + hibernate执行流程
        * 获取configuration对象(读取 hibernate.cfg.xml)  
        + configuration创建sessionFactory
            * 创建和销毁都相当耗费资源，通常一个系统内一个数据库只创建一个
            * 加载*.hbm.xml
        * sessionFactory创建session(类似于JDBC中的connection)
        * session在transaction中执行CRUD
    + 什么是session
        * 不建议直接使用jdbc的connection操作数据库，而是通过使用session操作数据库
        * 操作数据库的对象
    * session与connection，是多对一的关系，每个session都有一个与之对应的connection,
        一个connection不同时刻可以供多个session使用
                      

##transaction简介(详见com.rc.singletable.TransactionTest)
    + hibernate对数据库的操作都是封装在事务中的，并且默认是非自动提交的方式。所以用session保存对象时,如果不
        开启事务，并且手动提交事务，对象并不会真正保存在数据库中
    + 如果你想让hibernate像jdbc那样自动提交事务，必须调用session对象的doWork()方法，获得jdbc的connection
        后，设置为自动提交事务模式（注意：通常并不推荐这么做）

##session详解(详见com.rc.singletable.SessionTest)
    + 如何获得
        * openSession
        + getCurrentSession(需在hibernate.cfg.xml进行配置)
            * 本地事务，jdbc事务
                <property name="current_session_context_class">thread</property>
            
            * 全局事务，jta事务，需集成Jboss
                <property name="current_session_context_class">jta</property>
    + openSession与getCurrentSession区别
        * getCurrentSession在事务提交或者回滚之后会自动关闭，而openSession需要手动关闭。如果使用openSession而
            没有手动关闭，多次之后会导致连接池溢出                
        * openSession每次创建新的Session对象，getCurrentSession使用现有的session对象   
        
##hbm.xml配置文件常用配置    
    + 主键策略
        + native 
            * 对应mysql为increment
        * assigned
        * uuid
        
##单表操作(详见Student相关内容，包括student.hbm.xml,Student,StudentTest)
    + 单一主键 
        * assigned 由java应用程序负责生成(手工赋值)     
        * native 由底层数据库自动生成标示符,mysql对应increment,oracle对应sequence等等                             
    + 基本类型   
        + date
            * 映射类型(date)
            * java类型(java.util.Date或者java.sql.Date)
            * 标准SQL类型(DATE)
            * 描述(代表日期：yyyy-MM-dd)
        + time
            * 映射类型(time)
            * java类型(java.util.Date或者java.sql.Time)
            * 标准SQL类型(TIME)
            * 描述(代表时间：hh:mi:ss)
        + timestamp
            * 映射类型(timestamp)
            * java类型(java.util.Date或者java.sql.TimeStamp)
            * 标准SQL类型(TIMESTAMP)
            * 描述(代表日期和时间：yyyymmddhhmiss)
        + calendar
            * 映射类型(calendar)
            * java类型(java.util.Calendar)
            * 标准SQL类型(TIMESTAMP)
            * 描述(代表日期和时间：yyyymmddhhmiss)
        + calendar_date
            * 映射类型(calendar_date)
            * java类型(java.util.Calendar)
            * 标准SQL类型(DATE)
            * 描述(代表日期：yyyy-MM-dd)  
    + 对象类型
        + binary
            * 映射类型(binary)
            * java类型(byte[])
            * 标准SQL类型(VARCHAR或BLOB)
            * MYSQL类型(BLOB)
            * Oracle类型(BLOB)
        + text
            * 映射类型(text)
            * java类型(java.lang.String)
            * 标准SQL类型(CLOB)
            * MYSQL类型(TEXT)
            * Oracle类型(CLOB)
        + clob
            * 映射类型(clob)
            * java类型(java.sql.Clob)
            * 标准SQL类型(CLOB)
            * MYSQL类型(TEXT)
            * Oracle类型(CLOB)
        + blob
            * 映射类型(blob)
            * java类型(java.sql.Blob)
            * 标准SQL类型(BLOB)
            * MYSQL类型(BLOB)
            * Oracle类型(BLOB)
        * Mysql不支持标准SQL的CLOB类型，在Mysql中，用TEXT，MEDIUMTEXT及LONGTEXT类型来表示长度超过255的长文本类型
                                                                               
    + 组件属性 
        * 实体类中的某个属性属于用户自定义的类的对象,
        * 在student.hbm.xml做如下修改    
            <component name="address" class="com.rc.singletable.Address">
                <property name="postcode" column="postcode" type="string"/>
                <property name="phone" column="phone" type="string"/>
                <property name="address" column="address" type="string"/>
            </component>                              
    + CRUD  
        + get与load 区别
            + 是否立即调用
                * 在不考虑缓存的情况下，get方法会在调用之后立即向数据库发出sql语句                                 
                * load方法会在调用之后返回一个代理对象，该代理对象只保存了实体对象的id,直到使用对象的非主键属性时才会发出
                    SQL语句
            + 是否返回对象本身
                * 返回对象本身                                 
                * 返回代理对象
            + 查询数据库对象不存在的情况下
                * get方法返回null
                * load方法抛出org.hibernate.ObjectNotFoundException                 