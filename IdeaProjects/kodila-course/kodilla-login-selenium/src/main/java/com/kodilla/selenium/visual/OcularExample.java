package com.kodilla.selenium.visual;

import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class OcularExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        Ocular.config()
                .resultPath(Paths.get("c:/ocular/results"))
                .snapshotPath(Paths.get("c:/ocular/snapshots"))
                .globalSimilarity(95)
                .saveSnapshot(true);

        WorldTimePage page = new WorldTimePage(webDriver);

        page.open();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Accept']")));
        acceptCookiesButton.click();

        page.compare();
        page.close();
    }
}
