package com.krafttecnologies.tests.day20_DataDrivenFramework;

import com.krafttecnologies.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile(){
        /*
        1-ExcelUtil den bir obje oluşturulacak....
        2-Obje iki ayrı parametre alacak.. bunlar:Dosyanın pathi ve excel sheetinin (çalışma sayfası) ismi
         */

        ExcelUtil qaTeam3=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

        //satır sayısının alınması (row)
        System.out.println("qaTeam3.rowCount() = " + qaTeam3.rowCount());

        //sütun sayısının alınması(column)
        System.out.println("qaTeam3.columnCount() = " + qaTeam3.columnCount());

        //sütun adlarının alınması
        System.out.println("qaTeam3.getColumnsNames() = " + qaTeam3.getColumnsNames());

        //exceldeki bilgilerin alınması...
        List<Map<String, String>> dataList = qaTeam3.getDataList();

        System.out.println("dataList = " + dataList);

        //satır satır alalım
        for (Map<String,String> row:qaTeam3.getDataList()){
            System.out.println("row = " + row);
        }
            //3. satırı gertirelim
            System.out.println("dataList.get(2) = " + dataList.get(2));

            //satırın bir hücresindeki veriyi key ile alma
            System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));

            //dataları aray içerisine atalım... iki boyutlu array kullanacağız...row and column

            String[][] dataArray= qaTeam3.getDataArray();

            System.out.println(Arrays.deepToString(dataArray));

    }
}
