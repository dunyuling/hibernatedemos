##什么是ORM
+ ORM(Object/Relationship Mapping):对象/关系映射
    * 利用面向对象思想编写的数据库应用程序最终都把对象信息保存在关系型数据库中，于是要编写
        很多和底层数据库相关的SQL语句.---与面向对象思想格格不入
    + 写SQL语句有什么问题
        * 不同的数据库使用的SQL语法不同。比如PL/SQL与T/SQL
        * 相同的功能在不同数据库有不同实现方式。比如分页。
        * 程序过分依赖SQL对程序的移植及扩展，维护带来很大麻烦
    + 程序员彻底抛弃书写SQL的思想，完全使用面向对象思想开发软件

+ hibernate
    * Hibernate是java领域内一款开源的ORM框架技术。Hibernate对JDBC进行了非常
        轻量级的对象封装  
    + 映射
        * one to many
        * many to one
        * one to one
        * many to many                      
        
###创建mysql时的编码问题
CREATE DATABASE IF NOT EXISTS yourdbname DEFAULT CHARSET utf8 COLLATE utf8_general_ci;        