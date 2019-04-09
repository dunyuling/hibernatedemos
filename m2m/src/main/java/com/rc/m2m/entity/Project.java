package com.rc.m2m.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Project
 * @Description 项目类
 * @Author liux
 * @Date 19-4-8 下午1:43
 * @Version 1.0
 */
public class Project {

    private int proid;

    private String proname;

    private Set<Employee> employees = new HashSet<>();

    public Project() {
    }

    public Project(String proname) {
        this.proname = proname;
    }

    public Project(int proid, String proname, Set<Employee> employees) {
        this.proid = proid;
        this.proname = proname;
        this.employees = employees;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "proid=" + proid +
                ", proname='" + proname + '\'' +
                '}';
    }
}
