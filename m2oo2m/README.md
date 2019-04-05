##from:https://www.imooc.com/learn/334，有完善
##本项目讲述的是映射关系中的 one to many 和 many to one
##以前只知道通过pojo生成表，今天才知道也可以通过表生成pojo，以及x.hbm.xml. 这个功能是通过idea提供的Persistence模块实现的

## 一对多 (one to many)
    + 表现形式
        * 在数据库中，可以通过添加主外键的关联，表现一对多的关系
        * 通过在one持有many的集合实现，即在one端中使用<set>元素标识持有many的对象
    + 添加
        + 从one添加
            * 需在Grade.hbm.xml添加如下代码
                <set name="studentSet" table="student">
                    <key column="gid"/>
                    <one-to-many class="com.rc.m2oo2m.entity.Student"/>
                </set>
            * 配合StudentTest::testAddFromGrade()   
        
        + 从many添加
            * 需在Student.hbm.xml添加如下代码
                <many-to-one name="grade" class="com.rc.m2oo2m.entity.Grade" column="gid" cascade="none" />
            * 配合StudentTest::testAddFromStudent()  

    + 修改
        + 从one修改   
            * 配合StudentTest::updateStudentFromGrade()              
        + 从many修改            
            * 配合StudentTest::updateStudentFromStudent()   
        
## 多对一(many to one)
    * 多对一的关系和关系数据库中的外键参照关系最匹配，即在己方的表中的一个外键参照另一个表的主键
    * 通过many持有one的引用来实现，需在many端使用<many-to-one>的配置
    * 具体案例见(one to many)部分

    + inverse属性
        * one方<set>节点中的inverse属性指定关联关系的控制方向，默认由one方来维护

    + casecade属性
        * 当设置了casecade属性不为none时，Hibernate会自动持久化所关联的对象
        
        * case属性会带来性能上的变化，需谨慎
            * all:对所有操作进行级联操作
            * save-update:执行保存和更新时，进行级联操作
            * delete:执行删除时，进行级联操作
            * none:对所有操作不进行级联操作    

    + 在many方,casecade='save-update',inverse='true',并且执行StudentTest::testAddFromGrade方法，student表里的gid列为空。
        其实很好理解，casecade级联保存，即保存grade时保存关联学生;inverve又把控制权给了student方，所以student表里的gid列为空。
        
    + 最佳实践
        从one方的角度进行操作，从one方考虑级联问题，如StudentTest::testAddFromStudent方法所示
                       
        
                        