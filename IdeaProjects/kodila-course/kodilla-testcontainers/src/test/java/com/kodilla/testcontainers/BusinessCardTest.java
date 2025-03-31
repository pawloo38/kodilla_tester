package com.kodilla.testcontainers;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.DefaultRecordingFileFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

@Testcontainers
public class BusinessCardTest {

    private static Network network = Network.newNetwork();

    @Container
    public GenericContainer<?> webServer = new GenericContainer<>(
            new ImageFromDockerfile()
                    .withFileFromClasspath("business-card.html", "business-card.html")
                    .withDockerfileFromBuilder(builder ->
                            builder.from("httpd:2.4")
                                    .copy("business-card.html", "/usr/local/apache2/htdocs/business-card.html")
                                    .build()))
            .withNetwork(network)
            .withNetworkAliases("my-server")
            .withExposedPorts(80)
            .waitingFor(Wait.forHttp("/").forStatusCode(200));

    @Container
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withNetwork(network)
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("./build/recordings/"))
            .withRecordingFileFactory(new DefaultRecordingFileFactory());

    @Test
    void shouldLoadBusinessCardPageInChrome() {
        chrome.getWebDriver().get("http://my-server/");
        String pageSource = chrome.getWebDriver().getPageSource();

        assertTrue(pageSource.contains("Paweł Kieszonkowski"));
        assertTrue(pageSource.contains("883-940-440"));
        assertTrue(pageSource.contains("pawloo38@gmail.com"));
    }
}
