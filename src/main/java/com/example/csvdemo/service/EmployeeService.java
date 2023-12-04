package com.example.csvdemo.service;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.Employer;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employer> getAllEmployers();
}
