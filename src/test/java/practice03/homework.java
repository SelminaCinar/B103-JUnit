package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class homework extends TestBase {

    @Test
    public void test01() {

    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas).clickAndHold();

        for (int i = 0; i <10; i++) {
            actions.moveByOffset(5,5);

        }
        actions.release().build().perform();

    //- Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }
}
