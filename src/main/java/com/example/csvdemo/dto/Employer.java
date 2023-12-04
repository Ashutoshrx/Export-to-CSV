package com.example.csvdemo.dto;

import java.util.List;

public class Employer {
    private long companyId;
    private String companyName;
    private List<Employee> employees;

    public Employer(long companyId, String companyName, List<Employee> employees) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employees = employees;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
