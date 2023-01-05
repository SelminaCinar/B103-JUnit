package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow=driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();


        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
        String amazonWindow = driver.getWindowHandle();

        //    - iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String [] aramaSonuc = driver.findElement
                        (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().split(" ");
        System.out.println("Arama sonuc sayısı = "+aramaSonuc[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("Ilk window url'i : " + driver.getCurrentUrl());

        //    - amazon sekmeyi kapatalım
        driver.switchTo().window(amazonWindow);
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım
        //TestBasedeki After calisacak burda
    }
}
