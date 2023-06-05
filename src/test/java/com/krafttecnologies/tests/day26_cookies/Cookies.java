package com.krafttecnologies.tests.day26_cookies;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

public class Cookies {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void test1(){
  //      driver.get("https://www.hepsiburada.com/");
//        Set<Cookie> cookies = driver.manage().getCookies();
//        System.out.println("cookies = " + cookies);
 //       driver.manage().deleteAllCookies();
  //      driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
// Input Email id and Password If you are already Register
        driver.findElement(By.name("username")).sendKeys("mngr476556");
        driver.findElement(By.name("password")).sendKeys("ejamuqU");
        driver.findElement(By.name("submit")).click();
        File file = new File("Cookies.data"); // create file to store cookies
        try {
            file.delete(); // Delete old file if exists
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
// loop for getting the cookie information
            for(Cookie ck : driver.manage().getCookies()){
                Bwrite.write((ck.getName() +";"+ ck.getValue() +";"+ ck.getDomain() +";"+ ck.getPath()
                        + ";" + ck.getExpiry() +";"+ ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.flush(); Bwrite.close(); fileWrite.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try{
            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;
                    String val;
                    if(!(val=token.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    driver.manage().addCookie(ck); // This will add the stored cookie to current session
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        driver.navigate().refresh();
    }
}
