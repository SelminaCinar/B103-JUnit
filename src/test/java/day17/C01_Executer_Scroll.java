package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_Executer_Scroll extends TestBase {


    @Test
    public void scrollIntoViewTest() throws IOException {


       /*
        scrollIntoViewTest metotu olustur
        Techpro education ana sayfasina git
        We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
             */

            driver.get("https://www.techproeducation.com");
            waitFor(3);

            //1. elementi bul
            WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

            waitFor(3);

            //2. Js executer objesi olustur.
            JavascriptExecutor js = (JavascriptExecutor) driver;

            //3. yapmak istedigim islemi js.executeScript methodu ile yap
            //scrollIntoView(true); methodu belirli bir elemente scroll yapmak icin kullanilir,
            js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
            waitFor(3);

            takeScreenShotOfPage(); //ss aldik

            //bundan sonra artik ayni seyleri tekrar etmemek icin testbasede reusable method olusturacagiz.

            WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
            scrollIntoViewJS(enrollFree);
            waitFor(3);
            takeScreenShotOfPage();

            //why us icin
            scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
            waitFor(3);
            takeScreenShotOfPage();

            //tekrar enroll free
            scrollIntoViewJS(enrollFree);
            waitFor(3);
            takeScreenShotOfPage();

            //sayfanin en ustune cik
            scrollTopJS();
            waitFor(3);

            //sayfanin en altina in
            scrollEndJS();
            waitFor(3);

        }




    }

