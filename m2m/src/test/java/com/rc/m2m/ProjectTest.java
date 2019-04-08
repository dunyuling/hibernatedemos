package com.rc.m2m;

import com.rc.m2m.entity.Employee;
import com.rc.m2m.entity.Project;
import org.junit.Test;

/**
 * @ClassName ProjectTest
 * @Description 多对多关联关系的配置
 * @Author liux
 * @Date 19-4-8 下午2:01
 * @Version 1.0
 */
public class ProjectTest extends BaseTest {

    /*
     * @Author liux
     * @Description 多对多关系的写入
     * @Date 19-4-8 下午3:14
     * @param
     * @return void
     **/
    @Test
    public void testInsert() {
        Project p1 = new Project("p1");
        Project p2 = new Project("p2");

        Employee e1 = new Employee("e1");
        Employee e2 = new Employee("e2");

        p1.getEmployees().add(e1);
        p1.getEmployees().add(e2);

        p2.getEmployees().add(e1);

        session.save(p1);
        session.save(p2);
    }

    /*
     * @Author liux
     * @Description 多对多关系的查询--从employee角度
     * @Date 19-4-8 下午3:15
     * @param
     * @return void
     **/
    @Test
    public void testGetEmployee() {
        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee);
//        employee.getProjects().forEach(System.out::println);

    }

    /*
     * @Author liux
     * @Description 多对多关系的查询--从project角度
     * @Date 19-4-8 下午3:18
     * @param
     * @return void
     **/
    @Test
    public void testGetProject() {
        Project project = session.get(Project.class, 1);
        project.getEmployees().forEach(System.out::println);
    }
}