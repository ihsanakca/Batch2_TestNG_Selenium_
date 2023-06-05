package com.krafttecnologies.tests.day3_ders;

public class Properties {
    public static void main(String[] args) {

        java.util.Properties properties = System.getProperties();
        properties.list(System.out);

        System.out.println(properties.get("os.name"));

/*
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        //driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("sgezer@gmail.com");

        WebElement password=driver.findElement(By.id("yourPassword"));
        password.sendKeys("12345678");
        //password.sendKeys("12345678"+ Keys.ENTER);

        WebElement submitBtn=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        submitBtn.click();



 */

    }
}
