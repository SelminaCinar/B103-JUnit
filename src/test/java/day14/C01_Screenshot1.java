package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

    /*
    Selenium'da tum ekran goruntusu nasil alinir ?
    -tum ekran goruntusu getScreenshotAs metodu ile alinir.
    -getScreenshotAs metodu seleniumdaki TakesScreenshot api'indan gelir.
     */

    @Test
    public void screenshotTest() throws IOException {

//        Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");


        //1.Ekran goruntusunu getScreenshotAs methodu ile alip File olarak olusturalim
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2.Almis oldugum ekran goruntusunu belirledigim bir PATH'e kaydet
        //NOTE: kayit ismini dinamik yapmak icin date objesini kullandim
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        String path = System.getProperty("user.dir") + "/test-output/Screenshot/" + currentDate + "image.png";
        File hedef = new File(path);

        //Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(screenShot, hedef);

        //ALTERNATIF OLARAK TUM BU ADIMLARI DEGISKEN KULLANMADAN YAPABILIRIM
        //FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
        //        new File(System.getProperty("user.dir")+"/test-output/Screenshot/image2.png"));


//        -“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("qa" + Keys.ENTER);

//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected = "Search Results for: qa";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));

        //Reusable method ile ekran goruntusu alalim
        takeScreenShotOfPage();


    }
}
