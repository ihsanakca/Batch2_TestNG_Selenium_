package com.krafttecnologies.tests.day13_Ders_WebTables;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']//thead//th"));
        List<WebElement> rowsOfTable = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));

        int numberOfColumns=columnNames.size();
        int numberOfRows=rowsOfTable.size();

        System.out.println("dataOfCell(2,3) = " + dataOfCell(2, 3));
        System.out.println("---------------------");
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <=numberOfColumns ; j++) {
                System.out.print(dataOfCell(i, j)+" ");
            }
            System.out.println();
        }
    }

    String dataOfCell(int row,int column){
        return driver.findElement(By.xpath("//table[@id='table1']//" +
                "tbody//tr["+row+"]//td["+column+"]")).getText();
    }

}
