##from：https://www.imooc.com/learn/524


## Hibernate注解简介
    * 目的：简化繁琐的ORM映射文件(*.hbm.xml)的配置
    + JPA与Hibernate的关系
        + 什么是JPA
            * Java Persistence API 
            * JPA注解是JAVAEE的规范和标准
        * JPA是标准接口，Hibernate是实现，但是其功能是JPA的超集
        + 实现:通过三个组件来实现
            * hibernate-annotation
            * hibernate-entitymanager
            * hibernate-core                
    + Hibernate注解分类
        * 类级别注解
            @Entity
            @Table
            @Embeddable
        * 属性级别注解
        * 映射关系注解
    + schema与catalog        

##类级别注解（对应package:com.rc.annotation.clazz）
    + @Entity
        * @Entity:映射实体类
        + @Entity(name="tableName")
            name:可选，对应数据库中的一个表。若表名与实体类名相同，则可以省略
        * 注意：使用@Entity时必须指定实体类的主键属性 
    + @Table
        * @Table(name="",catalog="",schema="")
        * @Entity配合使用，只能标注在实体的class定义处，表示实体对应的数据库表信息       
        * name:可选，映射表的名称，默认表名和实体名称一致，只有在不一致时需指定
        * catalog:可选，表示Catalog名称，默认为Catalog("")
        * schema:可选，表示Schema名称，默认为Schema("")
        
        + catalog与schema
            * 数据库系统--一对多-->catlog--一对多-->schema(包含表，视图，字段）
                一个数据库属于一个schema
            + 从实现角度来看，各种数据库对Catalog和Schema的支持和实现都不一样
                + catalog    
                    * Oracle:不支持    
                    * MySQL:不支持    
                    * SQL Server:数据库名    
                    * DB2:指定数据库对象时，Catalog部分省略    
                + schema
                    * Oracle:Oracle User ID    
                    * MySQL:数据库名字   
                    * SQL Server:对象属主名，2005版开始有变    
                    * DB2:Catalog属主名
        
    + Embeddable
        * @Embeddable表示一个非Entity类可以嵌入到另一个Entity类中作为属性而存在
        
##属性级别注解(对应package:com.rc.annotation.clazz)
    + 添加方式
        * 写在属性字段上面
        * 写在属性的get访问器上面
    + @Id
        * 必须，定义了映射到数据库表的主键属性，一个实体类可以有一个或者多个属性被映射为主键
        * 注意：如果多个属性被定义为主键属性，该实体类必须实现serializable接口 
    + @SequenceGenerator
    + @GeneratedValue
        * @GeneratedValue(strategy=GenerationType.AUTO，generator="")
        * 可选，用于定义主键生成策略
        + strategy方式
            * GenerationType.AUTO:根据底层数据库自动选择                
            * GenerationType.IDENTITY：根据数据库的Identity字段生成
            * GenerationType.SEQUENCE：根据Sequence来决定主键的取值
            * GenerationType.TABLE：使用指定表来决定主键取值，结合@TableGenerator使用
                如：
                @Id
                @TableGenerator(name="tab_cat_gen",allocationSize=1)
                @GeneratedValue(strategy=GenerationType.Table)
        + generator
            * 表示主键生成器的名称，这个属性通常和ORM框架相关
            
        * 对于mysql数据库，@GeneratedValue(strategy= GenerationType.IDENTITY)，相当于指定主键的auto_increment              
    + @Column
        * 可将属性映射到列，使用该注解来覆盖默认值，@Column描述了数据库中该字段的详细定义，这对于JPA注解生成数据库表结构的工具非常有用
    + @Embedded
        * 是注释属性的，表示该属性的类是嵌入类
        * 注意：同时嵌入类也必须标注@Embeddable注解
        * 可以不写
    + @EmbeddedId
        * 使用嵌入式主键类实现复合主键
        * 注意：嵌入式主键类必须实现Serializable接口，有默认无参构造方法
        * 示例见User.java和UserPk.java
    + @Lob
    + @Version
    + @Basic
    + @Transient  
        * 可选，表示该属性北非一个要映射到数据库表的字段，ORM框架将该属性忽略。如果一个属性并非映射到数据库表的字段，
            就务必将其标为@Transient,否则ORM框架默认其注解为@Basic
            
##关系映射级别注解(对应package:com.rc.annotation.relation)
    + 实体之间的的映射关系
        * 一对一
        * 一对多(多对一)
        * 多对多

    + 一对一单向外键关联(对应package:com.rc.annotation.relation.oto_fk)
        * @oneToOne(cascade=CascadeType.ALL)
        * @JoinColumn(name="pid",unique=true)
        * 注意：保存时应该先保存外键对象，再保存主表对象                                          
    + 一对一双向外键(对应package:com.rc.annotation.relation.oto_bfk)
        * 主控方配置同一对一单项外键关联 
        * 被控方：@OneToOne(mappedBy="idCard")                    
        * 注意：双向关联，被空方必须设置mappedBy属性。因为双向关联只能交给一方去控制，
            不可能在双方都设置外键保存关联关系，否则双方都无法保存                     
    + 一对一单向外键联合主键关联                                           
    + 多对一单向外键关联                                           
    + 一对多单向外键关联                                           
    + 一对多双向外键关联                                           
    + 多对多单向外键关联                                           
    + 多对多双向外键关联                                           