package com.krafttecnologies.tests.day22_WriteToExcel;

import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.io.IOException;

public class WriteToExcelTest {

    WriteToExcel writeExcel=new WriteToExcel();
    TheMultiplicationTable table=new TheMultiplicationTable();
    @Test
    public void writeToExceltest1() throws IOException {
        for (int i = 0; i < 6; i++) {
            writeExcel.writeToExcel("Sayfa1","İhsan",i,0);
        }
    }
    @Test
    public void writeToExceltest2() throws IOException {
        writeExcel.writeToExcel("Sayfa1","selim",1,3);
    }
    @Test
    void multipleTest1() throws IOException {
        table.multiplicationTable();
    }
}
