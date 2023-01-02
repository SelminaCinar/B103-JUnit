package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

public class P06 {

   static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {

        // - ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 1; i < 25 ; i++) {

            urunler.get(i).click();
            System.out.println(i+" . baslik : "+driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
        //- Her sayfanın sayfa başlığını yazdıralım
        //- sayfayı kapatalım
    }







}
