package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest() {


        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
       driver.findElement(By.xpath("//div[@id='start']//button")).click();
     //  WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
     //   Assert.assertEquals("Hello World!", helloWorldElement.getText());
        //IMPLICIT WAIT ILE TESTCASE CALISMADI EXPLICIT WAIT ILE YAPMALIYIZ

        //Explicit wait

        //1.WebDriverWait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //2.wait objesini olusturup bekleme sorununu cozmeye calis
        WebElement helloWorldElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!", helloWorldElements.getText());



        //Hello World! Yazının sitede oldugunu test et
    }


}
