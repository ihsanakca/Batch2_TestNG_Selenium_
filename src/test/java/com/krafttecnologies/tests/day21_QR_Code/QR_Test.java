package com.krafttecnologies.tests.day21_QR_Code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QR_Test extends TestBase {

    @Test
    public void qrCodeTest() throws IOException, NotFoundException {
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
    }
}
