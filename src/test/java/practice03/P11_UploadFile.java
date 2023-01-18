package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_UploadFile extends TestBase {

    @Test
    public void uploadFileTest() {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
//        String farkliKisim = System.getProperty("user.home");
//        String ortakYol = "C:\\Users\\Toprak Gezi\\Desktop\\sen.txt";
//        String dosyaYolu = farkliKisim+ortakYol;
        String dosyaYolu = "C:\\Users\\Toprak Gezi\\Desktop\\sen.txt";


        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//*[@id='terms']")).click();
        waitFor(3);

        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(3);

        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
