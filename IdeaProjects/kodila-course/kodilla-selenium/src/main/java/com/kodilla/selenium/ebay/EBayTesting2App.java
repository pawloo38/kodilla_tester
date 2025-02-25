package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EBayTesting2App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        Thread.sleep(3000);
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        acceptCookiesButton.click();


        Thread.sleep(1600);
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchInput.sendKeys("Mavic mini");
        searchInput.sendKeys(Keys.RETURN);

        Thread.sleep(2200);
        WebElement categoryDropdown = driver.findElement(By.xpath("//select[@id='gh-cat']"));
        Select categorySelect = new Select(categoryDropdown);
        categorySelect.selectByValue("293");

        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//span[contains(@class,'gh-search-button__label')]"));
        searchButton.click();
    }
}
