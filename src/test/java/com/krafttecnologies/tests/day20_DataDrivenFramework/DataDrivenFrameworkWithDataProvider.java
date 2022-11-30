package com.krafttecnologies.tests.day20_DataDrivenFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFrameworkWithDataProvider {

    //önce @dataProviderdan metodumuzu oluşturuyoruz.
    //Bu metod testimize data sağlayacak..
    //iki boyutlu olarak datalar sağlanacak...

    @DataProvider(name = "AracSatisOranlari")
    public Object[][] testData(){

        String [][] data={

            {"Audi","100","80","65","55"},
            {"Honda","112","127","135","60"},
            {"Tesla","20","30","25","15"},
            {"Mazda","70","50","65","75"},
            {"Porche","40","43","22","17"},
            {"Toyota","100","180","165","155"},
            {"Volvo","66","33","22","77"},
            {"Mercedes","73","80","65","55"},

        };
        return data;
    }

    @Test(dataProvider ="AracSatisOranlari")
    public void test(String aracMarkasi, String ocak, String subat, String mart, String nisan){
        System.out.println("Arac Markasi :" +aracMarkasi+" : "+ocak+", "+subat+", "+mart+", "+nisan+"");

    }
}
