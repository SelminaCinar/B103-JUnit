package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P01_ExceptionPractice extends TestBase {

    @Test
    public void test() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Iphone aratalim
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //Cikan urunlerde sadece Apple Iphone yazanlari tiklayalim
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple Iphone"));

        //TEXT ICINDE APPLE IPHONE YAZISI GECENLERI ALACAK
        for (int i = 0; i < urunler.size() ; i++) {

            urunler = driver.findElements(By.partialLinkText("Apple Iphone"));
            urunler.get(i).click();
            driver.navigate().back();

        }

        //StaleElementException hatasini handle etmek icin loop icine webelementlerden olusturdugumuz
        //list'i koymaliyiz
    }
}
