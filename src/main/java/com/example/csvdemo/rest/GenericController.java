package com.example.csvdemo.rest;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.SheetInfo;
import com.example.csvdemo.dto.WorkbookDTO;
import com.example.csvdemo.helper.AparcheCsvExporter;
import com.example.csvdemo.helper.OpenCsvExportHelper;
import com.example.csvdemo.service.EmployeeService;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
//@RequestMapping("/v1")
public class GenericController {
    @Autowired
    private AparcheCsvExporter aparcheCsvExporter;
    @Autowired
    private OpenCsvExportHelper openCsvExportHelper;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/generic/aparche")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        // Assuming you have a WorkbookDTO instance named workbookDTO
        List<Employee> allEmployees = employeeService.getAllEmployees();
        WorkbookDTO workbookDTO = new WorkbookDTO();
        SheetInfo sheetInfo = new SheetInfo();
        sheetInfo.setData(allEmployees);
        String outputPath = "output.csv";
        sheetInfo.setSheetName(outputPath);
        workbookDTO.setSheetInfos(new ArrayList<>() {{
            add(sheetInfo);
        }});
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + outputPath + "\"");
        aparcheCsvExporter.exportToCsv(workbookDTO);
    }

    @GetMapping("/v1/generic/opencsv")
    public void exprortToCSVUsingOpenCsv(HttpServletResponse response) throws IOException, ClassNotFoundException {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        WorkbookDTO workbookDTO = new WorkbookDTO();
        SheetInfo sheetInfo = new SheetInfo();
        sheetInfo.setData(allEmployees);
//        Class<?> myClass = Class.forName(String.valueOf(sheetInfo.getData().getClass()));
//        System.out.println(myClass);
        String outputPath = "output.csv";
        sheetInfo.setSheetName(outputPath);
        workbookDTO.setSheetInfos(new ArrayList<>() {{
            add(sheetInfo);
        }});
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + outputPath + "\"");
        openCsvExportHelper.exportToCsv(workbookDTO);
    }

    /*@GetMapping("/v2/generic/opencsv")
    public ResponseEntity<byte[]> exportToCSVUsingOpenCsvV2() throws IOException, ClassNotFoundException {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        WorkbookDTO workbookDTO = new WorkbookDTO();
        SheetInfo sheetInfo = new SheetInfo();
        sheetInfo.setData(allEmployees);
        String outputPath = "test.csv";
        sheetInfo.setSheetName(outputPath);
        workbookDTO.setSheetInfos(new ArrayList<>() {{
            add(sheetInfo);
        }});
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.valueOf("text/csv"));
        header.setContentDisposition(ContentDisposition.parse("attachment; filename=\"" + outputPath + "\""));
        byte[] response = openCsvExportHelper.exportToCsv(workbookDTO);
        return ResponseEntity.ok().headers(header).body(Base64.getEncoder().encode(response));
    }*/
    @GetMapping("/v2/generic/opencsv")
    public ResponseEntity<byte[]> exportToCSVUsingOpenCsv() throws IOException, ClassNotFoundException {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        WorkbookDTO workbookDTO = new WorkbookDTO();
        SheetInfo sheetInfo = new SheetInfo();
        sheetInfo.setData(allEmployees);
        String outputPath = "output.csv";
        sheetInfo.setSheetName(outputPath);
        workbookDTO.setSheetInfos(new ArrayList<>() {{
            add(sheetInfo);
        }});

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentType(MediaType.valueOf("text/csv"));
        headers.setContentDisposition(ContentDisposition.parse("attachment; filename=\"" + outputPath + "\""));

        byte[] csvData = openCsvExportHelper.exportToCsv(workbookDTO);

        return ResponseEntity.ok().headers(headers).body(csvData);
    }
}
