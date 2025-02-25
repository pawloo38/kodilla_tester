import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class Testowa2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
        options.addArguments("--user-agent=" + userAgent);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.allegro.pl");
        Thread.sleep(3000);
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        acceptCookiesButton.click();

        WebElement inputField = driver.findElement(By.id("APjFqb"));


        String searchText = "alegro.pl";

        Random rand = new Random();

        for (char letter : searchText.toCharArray()) {
            inputField.sendKeys(String.valueOf(letter));
            int waitTime = rand.nextInt(900) + 100;
            Thread.sleep(waitTime);
        }

        inputField.sendKeys(Keys.ENTER);

        Thread.sleep(3000);


    }
}
