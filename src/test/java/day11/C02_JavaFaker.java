package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    Faker faker;

    @Test
    public void javaFakerTest() {
       //1.Adim Faker objesi olustur
        Faker faker = new Faker();

        //2.Adim Faker objesi ile fake data olustur

        //first name datasi
        String fName = faker.name().firstName();
        System.out.println(fName);

        //last name datasi
        String lName = faker.name().lastName();
        System.out.println(lName);

        //kullanici adi
        String username = faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //ful adress
        System.out.println(faker.address().fullAddress());

        //cep telefonu numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());


        /*
        TEST DATA : kullanici adi, sifre ,tel no , email,sehir , kredi kart no..
        Test datalari kimden alinir?
        -Business Analyst (BA)(Acceptance Criteria lari yazar.
        -Test Lead
        -Manuel Tester
        -Tech Lead veya Team Lead,Dev Lead
        -Developer
        -Data Base
        -API call lar
        -Documentations-Ornegin API swegger dokumani
        - Java Faker


        Test datalari kimden alinmaz ?
        -Kullanicidan alinmaz
        -Scrum master

         */
    }
}
