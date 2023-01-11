package practice03;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void cookieTest() {

        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");
        waitFor(15);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookie'lerin sayisi : " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie c : cookies) {
            System.out.println(c.getName() + " : " + c.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie", "123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("Yeni cookie sayisi : " + newCookies.size());
        //Isimleri
        for (Cookie c : newCookies) {
            System.out.println(c.getName() + " : " + c.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        System.out.println(newCookies.size());
    }
}
