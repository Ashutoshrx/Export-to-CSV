/*
package com.example.csvdemo.helper;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvProcessor {

    public static void main(String[] args) {
        try {
            // Step 1: Read the template CSV from InputStream
            InputStream templateStream = getTemplateInputStream(); // replace with your actual method to get InputStream

            List<String[]> templateData = readCsvFromInputStream(templateStream);

            // Step 2: Add additional data
            List<String[]> additionalData = getAdditionalData(); // replace with your actual method to get additional data

            templateData.addAll(additionalData);

            // Step 3: Write the combined data to a new CSV file
            byte[] csvBytes = writeCsvToByteArray(templateData);

            // Step 4: Export the byte array to a CSV file (or any other desired output)
            exportByteArrayToCsv(csvBytes, "output.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getTemplateInputStream() {
        // Replace this method with your logic to get the template InputStream
        // For example, you might be getting it from a file, network, etc.
        return CsvProcessor.class.getResourceAsStream("/template.csv");
    }

    private static List<String[]> readCsvFromInputStream(InputStream inputStream) throws IOException, CsvException {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }

    private static List<String[]> getAdditionalData() {
        // Replace this method with your logic to get additional data
        // For example, you might be extracting it from WorkBookDto
        return WorkBookDto.getSheetInfo().get(0).getData().get(0);
    }

    private static byte[] writeCsvToByteArray(List<String[]> data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

        // Write data to CSV
        csvWriter.writeAll(data);
        csvWriter.close();

        return outputStream.toByteArray();
    }

    private static void exportByteArrayToCsv(byte[] csvBytes, String outputFileName) throws IOException {
        // Replace this method with your logic to export the byte array to a CSV file
        // For example, you might be saving it to a file or sending it over a network
        try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.write(csvBytes);
        }
    }
}
*/
