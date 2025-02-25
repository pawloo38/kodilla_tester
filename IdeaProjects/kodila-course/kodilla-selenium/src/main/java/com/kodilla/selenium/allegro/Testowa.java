package com.kodilla.selenium.allegro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class Testowa {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(service, options);

        driver.get("https://www.allegro.pl");

    }
}
