package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {

    @Test
    public void screenshotTest2() throws IOException {

//        Techpro education a git
        driver.get("https://www.techproeducation.com");

//        Sosyal medya elemanlarını goruntusunu al
        WebElement sosyalMedyaIconlari = driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]"));
        File image = sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);

        //GORUNTUYU KAYDET

        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshot/" + currentDate + "image.png";
        FileUtils.copyFile(image,new File(path));

        //LOGONUN EKRAN GORUNTUSUNU AL
        takeScreenshotOfElement(driver.findElement(By.xpath("//img[@class='attachment-large size-large lazyloaded']")));

    }
}
