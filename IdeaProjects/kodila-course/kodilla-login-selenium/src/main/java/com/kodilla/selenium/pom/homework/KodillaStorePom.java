package com.kodilla.selenium.pom.homework;

import com.kodilla.selenium.pom.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KodillaStorePom extends AbstractPom {

    @FindBy(css = "input[type='search']")
    WebElement searchField;

    @FindBy(css = "button[type='submit']")
    WebElement searchButton;

    @FindBy(css = ".product-count")
    WebElement productCountElement;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int searchForProduct(String searchTerm) {
        searchField.clear();
        searchField.sendKeys(searchTerm);
        searchButton.click();

        String productCountText = productCountElement.getText();

        return Integer.parseInt(productCountText.split(" ")[0]);
    }
}
