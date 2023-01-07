package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {

//    Class : FileExistTest
//    Method : isExist
//    Masa ustunden bir dosyanın varligini test et


    @Test
    public void fileExistTest() {

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);

        //logo.jpeg indirip masaustune kaydedin

        //Logo masaustunde : /Users/ToprakGezi/Desktop

        String dosyaYolu = userHOME +"/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

       boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosya var ise true yok ise false
        Assert.assertTrue(isExist);
    }
}
