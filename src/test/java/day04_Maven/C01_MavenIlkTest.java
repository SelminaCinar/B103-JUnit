package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //3"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //aramaKutusu.submit();//Enter'a bastik


        //4Bulunan sonuc sayisini yazdiralim
        WebElement bulunanSonucSayisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(bulunanSonucSayisi.getText());

        //5Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkUrun.click();



         //6Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfaBasliklari) {
            System.out.println(w.getText());
        }

        //sayfaBasliklari.forEach(t-> System.out.println(t.getText()));
    }
}
