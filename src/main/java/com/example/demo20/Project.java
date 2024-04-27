package com.example.demo20;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String projectName;

    @ManyToMany
    private List<Employee> emps;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Project(int pid, String projectName, List<Employee> emps) {
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }

    public Project() {
    }
}
