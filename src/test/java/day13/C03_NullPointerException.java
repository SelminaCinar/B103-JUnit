package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException{

    WebDriver driver;
    Faker faker;


    @Test
    public void nullPointerExceptionTest() {

//        NullPointerException
//        Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
//        Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
//        Solution:
//        Degiskeni instantiate et

        driver.get("www.techproeducation.com");//NullPointerException
    }

    @Test
    public void nullPointerExceptionTest2() {

        System.out.println(faker.name().firstName());//NullPointerException
    }
}
