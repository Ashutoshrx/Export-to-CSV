package com.example.csvdemo.helper;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.SheetInfo;
import com.example.csvdemo.dto.WorkbookDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.*;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

import static org.springframework.util.ReflectionUtils.findField;

@Component
public class OpenCsvExportHelper {
    @Autowired
    private ObjectMapper objectMapper;



    public byte[] exportToCsv(WorkbookDTO workbookDTO) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             PrintWriter printWriter = new PrintWriter(byteArrayOutputStream)) {

            HeaderColumnNameMappingStrategy headerColumnNameMappingStrategy = new HeaderColumnNameMappingStrategy();
            headerColumnNameMappingStrategy.setType(Employee.class);


            CustomColumnMappingStrategy<Employee> customColumnMappingStrategy = new CustomColumnMappingStrategy<>(headerColumnNameMappingStrategy.generateHeader(Employee.class),"xyz");
            customColumnMappingStrategy.setType(Employee.class);

            StatefulBeanToCsv writer = new StatefulBeanToCsvBuilder(printWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR).withMappingStrategy(customColumnMappingStrategy)
                    .build();

            List<SheetInfo> sheetInfos = workbookDTO.getSheetInfos();
            for (SheetInfo s : sheetInfos) {
                writer.write(s.getData());
            }
//            writer.
            // Flush the PrintWriter to ensure data is written to the stream
            printWriter.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
