package com.rc.m2m.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author liux
 * @Date 19-4-8 下午1:44
 * @Version 1.0
 */
public class Employee  {

    private int empid;

    private String empname;

    private Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(String empname) {
        this.empname = empname;
    }

    public Employee(int empid, String empname, Set<Project> projects) {
        this.empid = empid;
        this.empname = empname;
        this.projects = projects;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                '}';
    }
}