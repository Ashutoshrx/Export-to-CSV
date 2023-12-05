package com.example.csvdemo.helper;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.poi.ss.formula.functions.T;

public class CustomColumnMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private String[] headers;

    public CustomColumnMappingStrategy() {
    }

    public CustomColumnMappingStrategy(String[] headers) {
        this.headers = headers;
    }

    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
        super.generateHeader(bean);
        return headers;
        //return new String[]{"ASHUTOSHEMAIL", "ASHUTOSHID", "FIRSTASHU", "LASTASHUTOSH", "SALARYASHU", "SINGERASHU"};
//        return null;
    }

}
