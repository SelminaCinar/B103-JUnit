package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.xml.sax.helpers.AttributeListImpl;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P05 extends TestBase {
    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");
        driver.switchTo().defaultContent();

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        WebElement elemantalSeleniumLinki = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantalSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elemantalSeleniumLinki.click();
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(windowHandles);
        driver.switchTo().window(windowHandles.get(1));

        //2.Yol
        /*
        Set<String> butunSekmeler = driver.getWindowHandles();

          // Açılan sayfada sayfa başlığını yazdırınız

            for (String w : butunSekmeler) {
                if (!w.equals(ilkSayfa)) {
                    driver.switchTo().window(w);
                }
            }
            System.out.println(driver.getTitle());
            String ikinciSayfa = driver.getWindowHandle();
         */

        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("Elemental Selenium Sayfa Basligi : " + driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabsLinki = driver.findElement(By.xpath("//*[@href='https://saucelabs.com/']"));
        Assert.assertTrue(sourceLabsLinki.isDisplayed());

        // Source Labs linkine tıklayın
        sourceLabsLinki.click();
        List<String> sourceLabsWindowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(sourceLabsWindowHandles);
        driver.switchTo().window(sourceLabsWindowHandles.get(2));

        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("Source Labs Sayfa Basligi : " + driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(sourceLabsWindowHandles.get(0));
        System.out.println("Url: " +driver.getCurrentUrl());

        // ilk sekmeyi kapatalım
        driver.close();
        driver.switchTo().window(sourceLabsWindowHandles.get(2));
        System.out.println("Url: " +driver.getCurrentUrl());

    }


}
