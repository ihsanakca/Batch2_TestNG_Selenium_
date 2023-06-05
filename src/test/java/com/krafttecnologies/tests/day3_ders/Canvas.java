package com.krafttecnologies.tests.day3_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Canvas {
    public static void main(String[] args) {

        /*

canvas task:
1-Navigate to url :https://www.instructure.com/canvas/login/free-for-teacher
2-Enter email box wrong email (should have @sss.com)
3-Enter password box wrong pass
4-Click submit button
5-Verify that warning message contains word of "Invalid"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.instructure.com/canvas/login/free-for-teacher");
        WebElement email=driver.findElement(By.id("edit-email"));
        email.sendKeys("bbbdbd@bbb.com");

        WebElement pass= driver.findElement(By.id("edit-password"));
        pass.sendKeys("dssdfsfsd");

        WebElement submitBtn=driver.findElement(By.id("edit-submit"));
        submitBtn.click();

        WebElement warnMes=driver.findElement(By.cssSelector("div[class='ic-flash-error flash-message-container']"));
        WebElement warnMes2=driver.findElement(By.cssSelector(".ic-flash-error.flash-message-container"));

        String actualText=warnMes.getText();
        String actualText2=warnMes2.getText();

        System.out.println("actualText = " + actualText);
        System.out.println("actualText2 = " + actualText2);
        
        if (actualText.contains("Invalid")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        driver.quit();
    }
}
