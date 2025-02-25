package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","c:/selenium-drivers/chrome/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        Thread.sleep(5000);
        driver.get("https://allegro.pl/");
//        Thread.sleep(3000);
//        WebElement acceptCookiesButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
//        acceptCookiesButton.click();
//        Thread.sleep(9000);
//        WebElement inputField = driver.findElement(By.id("APjFqb"));
//        String searchText = "otomoto";
//
//        Random rand = new Random();
//
//        for (char letter : searchText.toCharArray()) {
//            inputField.sendKeys(String.valueOf(letter));
//
//            int waitTime = rand.nextInt(4000) + 100;
//            Thread.sleep(waitTime);
//        }
//
//        inputField.sendKeys(Keys.ENTER);
    }
}
