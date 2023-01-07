package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C01_Actions5 extends TestBase {
    @Test
    public void keyboardActionsTest() {

//    Create a method keyboardActions


//    Google a gidin https://www.google.com
//    ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)

//‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//    Ve ENTER tusuna bas
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
       // searchBox.sendKeys("iphone x fiyatlari" + Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.keyDown(searchBox,Keys.SHIFT).//arama kutusunun ustunde SHIFT tusuna bas
                sendKeys("IPhone X fiyatlari").//shifte basiliyken yazi yaz
                keyUp(searchBox,Keys.SHIFT)//SHIFTE artik basma
                .sendKeys("   cok pahali!" + Keys.ENTER)
                .build()//birden fazla actions methodu kullanildiginda build() fonskiyonu kullanilmalidir,baglanti guclu olur.Zorunlu degildir.
                .perform();//normal halde yaz ve Enter tusuna bas




    }

}
