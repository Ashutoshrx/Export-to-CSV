package com.example.csvdemo.dto;

import java.util.List;

public class WorkbookDTO {
    private List<SheetInfo> sheetInfos;

    public List<SheetInfo> getSheetInfos() {
        return sheetInfos;
    }

    public void setSheetInfos(List<SheetInfo> sheetInfos) {
        this.sheetInfos = sheetInfos;
    }
}
