package com.krafttecnologies.tests.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithoutSelect {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //Dropdown menuyu locate ediyoruz...
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownMenu=driver.findElement(By.xpath("( //div[@class=' css-1wa3eu0-placeholder'])[1]"));
        System.out.println("dropDownMenu.getText() = " + dropDownMenu.getText());

        //kutudaki ilk elementi assert edelim....

        String expectedOption="Select Option";
        String actualOption=dropDownMenu.getText();

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //Dropdown içerisinde Group 2 Option 1 seceneğini çağıralım...
        //sorun inspect yapılmak istendiğinde kaybolmasıdır.
        //aşmak için Event Listeners dan blur altındaki öğeler remove edilir...

        dropDownMenu.click();

        WebElement group2Option1= driver.findElement(By.cssSelector("#react-select-2-option-1-0"));

        group2Option1.click();

//        String expected="Group 2, option 1";  //buradan verify olmuyor..onun yerine tıklandıktan sonraki halini yeniden
//        String actual=group2Option1.getText(); //locate edip getText yapmalıyız.... aşağıdaki gibi...
//        System.out.println("actual = " + actual);
//        Assert.assertEquals(actual,expected,"FAIL");

        //Group 2 Option 1 seçildikten sonra verify etmek için tekrar locate ediyoruz...

        WebElement selectOption=driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        System.out.println("selectOption.getText() = " + selectOption.getText());

        String expectedOption2="Group 2, option 1";
        String actualOption2=selectOption.getText();

        Assert.assertEquals(actualOption2,expectedOption2,"FAIL");

        Thread.sleep(2000);
    }
}
