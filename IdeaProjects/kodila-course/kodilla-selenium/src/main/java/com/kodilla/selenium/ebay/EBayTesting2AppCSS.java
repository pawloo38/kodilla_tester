package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EBayTesting2AppCSS {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gdpr-banner-accept")));
        acceptCookiesButton.click();

        Thread.sleep(1600);

        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys("Mavic mini");
        searchInput.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".srp-results")));

        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.sendKeys("Consumer Electronics");

        WebElement searchButton = driver.findElement(By.className("gh-search-button__label"));
        searchButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".srp-results")));

        List<WebElement> productCards = driver.findElements(By.cssSelector(".s-item"));

        for (WebElement productCard : productCards) {
            System.out.println(productCard.getText());
        }
    }
}
