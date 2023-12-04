package com.example.csvdemo.helper;

import com.example.csvdemo.dto.Employee;
import com.example.csvdemo.dto.SheetInfo;
import com.example.csvdemo.dto.WorkbookDTO;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class OpenCsvExportHelper {


    //    @TODO working code
    public byte[] exportToCsv(WorkbookDTO workbookDTO) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             PrintWriter printWriter = new PrintWriter(byteArrayOutputStream)) {
            HeaderColumnNameMappingStrategy headerColumnNameMappingStrategy = new HeaderColumnNameMappingStrategy();
            headerColumnNameMappingStrategy.setType(workbookDTO.getSheetInfos().get(0).getData().get(0).getClass());
            StatefulBeanToCsv writer = new StatefulBeanToCsvBuilder(printWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR).withMappingStrategy(headerColumnNameMappingStrategy)
                    .build();

            List<SheetInfo> sheetInfos = workbookDTO.getSheetInfos();
            for (SheetInfo s : sheetInfos) {
                writer.write(s.getData());
            }

            // Flush the PrintWriter to ensure data is written to the stream
            printWriter.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
/*    public byte[] exportToCsv(WorkbookDTO workbookDTO) {
        try (StringWriter stringWriter = new StringWriter();
             CSVWriter csvWriter = new CSVWriter(stringWriter,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.NO_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(T.class);

            StatefulBeanToCsv writer = new StatefulBeanToCsvBuilder(csvWriter)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            List<SheetInfo> sheetInfos = workbookDTO.getSheetInfos();
            for (SheetInfo s : sheetInfos) {
                writer.write(s.getData());
            }

            // Get the CSV data as a string
            String csvData = stringWriter.toString();
            System.out.println(csvData);
            // Convert the string to a byte array
            return csvData.getBytes(StandardCharsets.UTF_8);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }*/


}
