package com.example.csvdemo.service.impl;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.Employer;
import com.example.csvdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>() {{
            add(new Employee(1, null, "Sata", "ashu@sata.com", 25, true));
            add(new Employee(2, "Ashu", "Sata", "ashu@sata.com", 38, true));
            add(new Employee(3, "Pathy", "Sata", "pathy@sata.com", 25, true));
            add(new Employee(4, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(5, "Ashu", "Sata", "ashu@sata.com", 25, true));
            add(new Employee(6, "Ashu", "Sata", "ashu@sata.com", 25, true));
            add(new Employee(7, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(8, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(9, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(10, "Pathy", "Sata", "ron@sata.com", 38, false));
            add(new Employee(11, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(12, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(13, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(14, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(15, "Pathy", "Sata", "ron@sata.com", 38, false));
            add(new Employee(16, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(17, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(18, "Pathy", "Sata", "ronnie@sata.com", 38, false));
            add(new Employee(19, "Pathy", "Satapathy", "pathy@sata.com", 38, false));
            add(new Employee(20, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(21, "Pathy", "Sata", "ron@sata.com", 38, false));
            add(new Employee(22, "Pathy", "Satapathy", "pathy@sata.com", 38, false));
            add(new Employee(23, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(24, "Pathy", "Sata", "ronnie@sata.com", 38, false));
            add(new Employee(25, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(26, "Pathy", "Satapathy", "pathy@sata.com", 38, false));
            add(new Employee(27, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(28, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(29, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(30, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(31, "Ronnie", "Satapathy", "pathy@sata.com", 38, false));
            add(new Employee(32, "Pathy", "Sata", "ronnie@sata.com", 38, false));
            add(new Employee(33, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(34, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(35, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(37, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(38, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(39, "Pathy", "Satapathy", "pathy@sata.com", 38, false));
            add(new Employee(40, "Pathy", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(41, "Pathy", "Sata", "ronnie@sata.com", 38, false));
            add(new Employee(42, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(43, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(44, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(45, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(46, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(47, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(48, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(49, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(50, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(51, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(52, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(53, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(54, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(55, "Ronnie", "Sata", "pathy@sata.com", 38, false));
            add(new Employee(56, "Ronnie", "Sata", "pathy@sata.com", 38, false));
        }};
    }

    @Override
    public List<Employer> getAllEmployers() {
        List<Employee> employees = getAllEmployees();
        return new ArrayList<>() {{
            add(new Employer(1, "Tavant", employees.stream().filter
                    (employee -> employee.getFirstName().equals("Pathy")).collect(Collectors.toList())));
            add(new Employer(2, "Technologies", employees.stream().filter
                    (employee -> employee.getFirstName().equals("Ashu")).collect(Collectors.toList())));
        }};
    }
}
