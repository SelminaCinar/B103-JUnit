package Practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void windowHandleTest() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String handle1 = driver.getWindowHandle();


        // 2- nutella icin arama yapın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("Nutella", Keys.ENTER);

        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkUrun.click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        WebElement baslik = driver.findElement(By.xpath("//*[@id='productTitle']"));
        String baslikSrt =baslik.getText();
        System.out.println("Sayfanin basligi : " + baslikSrt);

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(handle1);
        String url = driver.getCurrentUrl();
        System.out.println("Ilk sayfa url'i : " + url);
    }
}
