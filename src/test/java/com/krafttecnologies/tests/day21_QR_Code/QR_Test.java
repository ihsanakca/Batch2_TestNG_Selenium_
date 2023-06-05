package com.krafttecnologies.tests.day21_QR_Code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QR_Test  {
    WebDriver driver;
    @Test
    public void qrCodeTest() throws IOException, NotFoundException {

        driver= Driver.get();
        driver.get("https://goqr.me/");
        String urlText="https://www.google.com/";
        driver.findElement(By.xpath("//textarea[@id='qrcode-field-text-text']")).sendKeys(urlText);
        BrowserUtils.waitFor(3);
        String qrCodeUrl = driver.findElement(By.xpath("//img[@id='qrcode-preview-image']")).getAttribute("src");

        URL url = new URL(qrCodeUrl);

        BufferedImage bufferedImage = ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);
        String textResult = result.getText();

        System.out.println("textResult = " + textResult);
        driver.get(textResult);
        Assert.assertEquals(driver.getCurrentUrl(),urlText,"QR code control");

        driver.quit();
    }
}
