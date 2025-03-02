package com.kodilla.selenium.pom.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KodillaStorePomApplication {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        KodillaStorePom storePom = new KodillaStorePom(driver);

        System.out.println("Wyniki wyszukiwania dla frazy 'NoteBook': " + storePom.searchForProduct("NoteBook"));
        System.out.println("Wyniki wyszukiwania dla frazy 'School': " + storePom.searchForProduct("School"));
        System.out.println("Wyniki wyszukiwania dla frazy 'Brand': " + storePom.searchForProduct("Brand"));
        System.out.println("Wyniki wyszukiwania dla frazy 'Business': " + storePom.searchForProduct("Business"));
        System.out.println("Wyniki wyszukiwania dla frazy 'Gaming': " + storePom.searchForProduct("Gaming"));
        System.out.println("Wyniki wyszukiwania dla frazy 'Powerful': " + storePom.searchForProduct("Powerful"));

       driver.close();
    }
}
