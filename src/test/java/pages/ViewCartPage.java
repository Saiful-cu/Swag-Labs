package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends BasePage {
    private final By continueShopping = By.xpath("//button[@id='continue-shopping']");
    private final By checkout = By.xpath("//button[@id='checkout']");


    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        driver.findElement(checkout).click();
    }

    public void continueShopping() {
        driver.findElement(continueShopping).click();
    }

    public boolean isCartPageDisplayed() {
        return isElementDisplayed(driver.findElement(checkout));
    }
}
