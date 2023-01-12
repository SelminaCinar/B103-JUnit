package Practice_Burak;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void windowHandleTest2() {
        // ...Exercise 2...


        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String handle1 = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(handle1);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        // 7- ikinci sayfaya(bestbuy) donelim
        // 8- logonun gorundugunu test edelim
    }
}
