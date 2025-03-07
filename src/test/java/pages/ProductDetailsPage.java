package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {
    private final By backToProduct = By.xpath("//button[@id = 'back-to-products']");
    private final By addToCart = By.xpath("//button[@id='add-to-cart']");
    private final By viewCart = By.xpath("//a[@class='shopping_cart_link']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
        driver.findElement(addToCart).click();
    }

    public void backToProduct() {
        driver.findElement(backToProduct).click();
    }

}
