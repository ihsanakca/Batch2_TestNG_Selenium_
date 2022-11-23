package com.krafttecnologies.test.day13_WebTables;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void printTable (){
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        WebElement table=driver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));
        System.out.println(table.getText());
    }
    @Test
    public void printAllHeaders(){
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        WebElement headers=driver.findElement(By.xpath("//table[@class='table table-light traversal-table']/thead"));
        System.out.println(headers.getText());
    }
    @Test
    public void printTableSize(){
        //th tagindadi elementlerin size ı alalım
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
       List<WebElement> thSize = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //th"));
        System.out.println("thSize.getSize() = " + thSize.size());

        //rows satırların size ı
        List<WebElement> rwSize=driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tr"));
        System.out.println("rwSize.size() = " + rwSize.size());

        //headers başlıklar hariç rows satırların size ı bulalım
        List<WebElement> rowsWithoutHeaders=driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr"));
        System.out.println("rowsWithoutHeaders.size() = " + rowsWithoutHeaders.size());
    }

    @Test
    public void getRow(){
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        WebElement row2= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]"));

        System.out.println("row2.getText() = " + row2.getText());
    }

    @Test
    public void getAllRows() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        List<WebElement> allRows=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));
        Thread.sleep(2000);

        for (int i=1;i<=allRows.size();i++){
            WebElement row=driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }


    }
    @Test
    public void getAllCellsOneRow(){
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        List<WebElement> allCells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]//td"));

        for (WebElement allCell : allCells) {
            System.out.println("allCell.getText() = " + allCell.getText());

        }
        System.out.println("allCells.get(0).getText() = " + allCells.get(0).getText());

        WebElement jacob=driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]//td[1]"));
        System.out.println("jacob.getText() = " + jacob.getText());
    }
    @Test
    public void getCellText(){
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        List<WebElement> thirdCells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[3]//td"));
        System.out.println("thirdCells.get(1).getText() = " + thirdCells.get(1).getText());

    }
    @Test
    public void test1() throws InterruptedException {
        //canvastaki captcha ya tıklama kodu...
        driver.get("https://us02web.zoom.us/rec/share/Ux_SMB1NZsOFTUb7j_UyLYBmko3J5Plc4NB1b4nN_86M14WFFFeUkXgo9B_YKUig.rayXTel9S1jhuTVT");

        WebElement cerez= driver.findElement(By.id("onetrust-accept-btn-handler"));
        cerez.click();

        WebElement iframe=driver.findElement(By.xpath("(//iframe)[1]"));
        Thread.sleep(5000);
        driver.switchTo().frame(iframe);

        WebElement cap=driver.findElement(By.className("recaptcha-checkbox-checkmark"));
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",cap);
        Thread.sleep(5000);

    }

}
