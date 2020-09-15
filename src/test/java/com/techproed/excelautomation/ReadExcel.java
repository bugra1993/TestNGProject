package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String filePath = "src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell ulkeler = row.getCell(0);
        Cell baskentler = row.getCell(1);
        Cell meshurlar = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));

        int rowCount = workbook.getSheetAt(0).getLastRowNum();
        System.out.println("row count : " + rowCount);

        int fullRowCount = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("full row count : " + fullRowCount);

        int lastRowIndex = workbook.getSheetAt(0).getLastRowNum();

        for (int i = 0; i <= lastRowIndex; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));

        }

        for (int i = 0; i <= lastRowIndex; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));

        }

        int columnCount = workbook.getSheetAt(0).getRow(1).getLastCellNum();

        for (int i = 0; i < columnCount; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(i));
        }

    }
}
