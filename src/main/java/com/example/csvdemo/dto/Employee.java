package com.example.csvdemo.dto;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;

import java.io.Serializable;

public class Employee implements Serializable {
    @CsvBindByPosition(position = 6)
    @CsvBindByName(column = "AshutoshId")
    private long id;

    @CsvBindByPosition(position = 5)
    @CsvBindByName(column = "AshutoshFirstName")
    private String firstName;
    @CsvBindByPosition(position = 1)
    @CsvBindByName(column = "AshutoshLastName")
    private String lastName;
    @CsvBindByPosition(position = 9)
    @CsvBindByName(column = "AshutoshEmail")
    private String email;
    @CsvBindByPosition(position = 2)
    @CsvBindByName(column = "AshutoshSalary")
    private Integer salary;
    @CsvBindByPosition(position = 3)
    @CsvBindByName(column = "IsAshutoshSinger")
    private boolean isSinger;

    public long getId() {
        return id;
    }

    public Employee(long id, String firstName, String lastName, String email, Integer salary, boolean isSinger) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.isSinger = isSinger;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean isSinger() {
        return isSinger;
    }

    public void setSinger(boolean singer) {
        isSinger = singer;
    }


}
