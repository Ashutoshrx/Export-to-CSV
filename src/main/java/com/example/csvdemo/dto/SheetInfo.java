package com.example.csvdemo.dto;

import java.util.List;

public class SheetInfo<T> {
    private String sheetName;
    private List<T> data;
    private Integer dataStartRow;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getDataStartRow() {
        return dataStartRow;
    }

    public void setDataStartRow(Integer dataStartRow) {
        this.dataStartRow = dataStartRow;
    }
}
