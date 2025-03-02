package com.kodilla.selenium.pom.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStorePomTest {

    KodillaStorePom storePom;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePom = new KodillaStorePom(driver);
    }

    @Test
    public void testSearchNoteBook() {
        int expectedResults = 10;
        int resultCount = storePom.searchForProduct("NoteBook");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchSchool() {
        int expectedResults = 5;
        int resultCount = storePom.searchForProduct("School");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchBrand() {
        int expectedResults = 8;
        int resultCount = storePom.searchForProduct("Brand");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchBusiness() {
        int expectedResults = 6;
        int resultCount = storePom.searchForProduct("Business");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchGaming() {
        int expectedResults = 12;
        int resultCount = storePom.searchForProduct("Gaming");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchPowerful() {
        int expectedResults = 7;
        int resultCount = storePom.searchForProduct("Powerful");
        assertEquals(expectedResults, resultCount);
    }

    @Test
    public void testSearchCaseInsensitive() {
        String searchTerm = "notebook";
        int resultCountLowercase = storePom.searchForProduct(searchTerm.toLowerCase());
        int resultCountUppercase = storePom.searchForProduct(searchTerm.toUpperCase());

        assertEquals(resultCountLowercase, resultCountUppercase);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
