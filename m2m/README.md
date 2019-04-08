##from:https://www.imooc.com/learn/452

##多对多关联(many-to-many)
    * 多对多关联也是一种常见的关联关系，如项目和员工之间就是典型的多对多关系
    * 多对多关联关系一般采用中间表的形式来实现，即新增一张包含关联双方主键的关联表
    * 多对多关联关系可以使用<set>元素和<many-to-many>元素进行配置
    
    * 没有写中间类以及中间类关联的.hbm.xml,具体映射配置查看Project.hbm.xml,以及
        Employee.hbm.xml。
    
    + 对比
        * 自动生成的中间表的描述如下:
             CREATE TABLE `proemp` (
              `rproid` int(11) NOT NULL,
              `rempid` int(11) NOT NULL,
              PRIMARY KEY (`rempid`,`rproid`),
              KEY `FKiqt91s5jy7sq9gbidqrwj5ivi` (`rproid`),
              CONSTRAINT `FKiqt91s5jy7sq9gbidqrwj5ivi` FOREIGN KEY (`rproid`) REFERENCES `project` (`proid`),
              CONSTRAINT `FKnlacpncrugvatd1r98gw4h39w` FOREIGN KEY (`rempid`) REFERENCES `employee` (`empid`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8 
            
        * 手写的sql如下
            create table proemp(
              rproid int ,
              rempid int
            );
            
            alter table proemp add constraint fk_rproid foreign key (rproid) references project(proid);
            alter table proemp add constraint fk_rempid foreign key (rempid) references employee(empid);
        
    
        
    
    