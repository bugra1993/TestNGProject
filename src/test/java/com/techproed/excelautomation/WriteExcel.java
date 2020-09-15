package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {
        String filePath = "src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("POPULATION");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80.000.000");
        workbook.write(fileOutputStream);

        Cell deleteCell = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(deleteCell);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }
}
