package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPage extends BasePage {

    public SuccessfulOrderPage(WebDriver driver){
        super(driver);
    }
    private final By successMess = By.xpath("//h2[@class='complete-header']");
    private final By backButton = By.xpath("//button[@id='back-to-products']");

    public String successMessage(){
        return driver.findElement(successMess).getText();
    }
    public void clickBackButton(){
        driver.findElement(backButton).click();
    }
}
