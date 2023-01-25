package com.krafttecnologies.tests.day22_WriteToExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteToExcel {
   public void writeToExcel(String sheetName, String cellValue, int row, int column) throws IOException {
       String excelPath="C:/Users/HP/Desktop/deneme.xlsx";

       File file=new File(excelPath);
       FileInputStream fis=new FileInputStream(file);
       XSSFWorkbook wb=new XSSFWorkbook(fis);
       XSSFSheet sheet=wb.getSheet(sheetName);

       sheet.getRow(row).createCell(column).setCellValue(cellValue);
       FileOutputStream fos=new FileOutputStream(new File(excelPath));
       wb.write(fos);
       wb.close();
       fos.close();
   }

}
