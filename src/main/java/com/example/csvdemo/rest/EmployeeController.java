package com.example.csvdemo.rest;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.Employer;
import com.example.csvdemo.helper.AparcheCsvExporter;
import com.example.csvdemo.service.EmployeeService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AparcheCsvExporter aparcheCsvExporter;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/csvexport")
    public void exportCSV(HttpServletResponse response)
            throws Exception {

        //set file name and content type
        String filename = "Employee-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Employee> writer = new StatefulBeanToCsvBuilder<Employee>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(employeeService.getAllEmployees());

    }

    @GetMapping("/employers/csvexport")
    public void exportToCSV(HttpServletResponse response)
            throws Exception {

        //set file name and content type
        String filename = "Employee-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Employer> writer = new StatefulBeanToCsvBuilder<Employer>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(employeeService.getAllEmployers());

    }

    @GetMapping("/aparche/export")
    public void exportUsingAparche(HttpServletResponse response) {
        //set file name and content type
        String filename = "Employee-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        System.out.println(employeeService.getAllEmployees());
//        csvExporter.exportToCsv(employeeService.getAllEmployees());
    }
}
