package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstName = By.xpath("//input[@id='first-name']");
    private final By lastName = By.xpath("//input[@id='last-name']");
    private final By postalCodes = By.xpath("//input[@id='postal-code']");
    private final By cancel = By.xpath("//input[@id='cancel']");
    private final By continues = By.xpath("//input[@id='continue']");
    private final By finish = By.xpath("//button[@id='finish']");


    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void addAddressDetails(String first_name, String last_name, String postalCode){
        driver.findElement(firstName).sendKeys(first_name);
        driver.findElement(lastName).sendKeys(last_name);
        driver.findElement(postalCodes).sendKeys(postalCode);
    }
    public void clickContinue(){
        driver.findElement(continues).click();
    }
    public void clickCancel(){
        driver.findElement(cancel).click();
    }
    public void clickFinish(){
        driver.findElement(finish).click();
    }
}
