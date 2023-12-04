package com.example.csvdemo.helper;

import com.example.csvdemo.dto.SheetInfo;
import com.example.csvdemo.dto.WorkbookDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

@Component
public class AparcheCsvExporter<T> {

    /*public void exportToCsv(WorkbookDTO workbookDTO, String outputPath, PrintWriter writer) {
        try (
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

            List<SheetInfo> sheetInfos = workbookDTO.getSheetInfos();
            for (SheetInfo<?> sheetInfo : sheetInfos) {
                String sheetName = sheetInfo.getSheetName();
                List<?> data = sheetInfo.getData();
                System.out.println(data);
                Integer dataStartRow = sheetInfo.getDataStartRow();

                // Write sheet name as a comment
                csvPrinter.printComment("Sheet Name: " + sheetName);
                // Write header if data is not empty
                if (!data.isEmpty()) {
                    writeHeadersToCsv(data.get(0).getClass(), csvPrinter);
                }
                System.out.println("Classname is:"+data.get(0).getClass());
                csvPrinter.println();
//                writeDataToCsv(data, csvPrinter);
//                for (int i = 0; i < data.size(); i++) {
//                    csvPrinter.printRecord(getFieldValues(data.get(i)));
//                }
//                csvPrinter.println()
                writeDataToCsv(data, dataStartRow, csvPrinter);
            }

            csvPrinter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/




        public byte[] exportToCsv(WorkbookDTO workbookDTO) {
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                 PrintWriter writer = new PrintWriter(byteArrayOutputStream);
                 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

                List<SheetInfo> sheetInfos = workbookDTO.getSheetInfos();
                for (SheetInfo<?> sheetInfo : sheetInfos) {
                    String sheetName = sheetInfo.getSheetName();
                    List<?> data = sheetInfo.getData();
                    Integer dataStartRow = sheetInfo.getDataStartRow();

                    // Write sheet name as a comment
                    csvPrinter.printComment("Sheet Name: " + sheetName);

                    // Write header if data is not empty
                    if (!data.isEmpty()) {
                        writeHeadersToCsv(data.get(0).getClass(), csvPrinter);
                    }

                    csvPrinter.println();
                    writeDataToCsv(data, dataStartRow, csvPrinter);
                }

                csvPrinter.flush();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*private void writeHeadersToCsv(Class<?> clazz, CSVPrinter csvPrinter) throws IOException {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                csvPrinter.print(field.getName());
            }
            csvPrinter.println();
        }

        private <T> void writeDataToCsv(List<T> data, Integer dataStartRow, CSVPrinter csvPrinter) throws IOException {
            for (int i = 0; i < data.size(); i++) {
                csvPrinter.printRecord(getFieldValues(data.get(i)));
            }
            csvPrinter.println();
        }*/





    //method to get field names and set as headers.
    private void writeHeadersToCsv(Class<?> clazz, CSVPrinter csvPrinter) throws IOException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            csvPrinter.print(field.getName());
            System.out.println("Fields:" + field);
        }
//        csvPrinter.println(); //@TODO Used to print in new line
    }

    private <T> void writeDataToCsv(List<T> data, Integer dataStartRow, CSVPrinter csvPrinter) throws IOException {
        for (int i = 0; i < data.size(); i++) {
//            csvPrinter.printRecord(data.get(i));
            csvPrinter.printRecord(getFieldValues(data.get(i)));
            System.out.println(data.get(i));
        }
        csvPrinter.println();
    }
    private Object[] getFieldValues(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Object[] values = new Object[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                values[i] = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return values;
    }
}
