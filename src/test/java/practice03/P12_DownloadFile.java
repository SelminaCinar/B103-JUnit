package practice03;

import com.mongodb.client.model.geojson.LineString;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P12_DownloadFile extends TestBase {

    @Test
    public void downloadTest() {

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        waitFor(2);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        waitFor(3);

        //Driver'in indiğini doğrulayalım
        //"C:\Users\Toprak Gezi\Downloads\chromedriver_win32 (1).zip"

        String dosyaYolu = System.getProperty("user.home")+"\\" + "\\Downloads\\chromedriver_win32.zip";
        assert Files.exists(Paths.get(dosyaYolu));


    }
}
