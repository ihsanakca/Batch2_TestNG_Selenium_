package com.krafttecnologies.tests.day22_WriteToExcel;

import java.io.IOException;

public class TheMultiplicationTable {
    WriteToExcel obj=new WriteToExcel();

    public static void main(String[] args) {

    }
    public void multiplicationTable() throws IOException {
        for (int i = 0; i <=10; i++) {
            for (int j = 0; j <=10 ; j++) {

                int result=i*j;
                String result1=Integer.toString(result);
                obj.writeToExcel("Sayfa1",result1,i,j);
                //System.out.print(result+"\t");
            }
           // System.out.println();
        }
    }
}
