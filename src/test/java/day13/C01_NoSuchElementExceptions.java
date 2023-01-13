package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementExceptions extends TestBase {

    @Test
    public void exceptionsTest() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA" + Keys.ENTER);
    }
}
