package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id = 'password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage =  By.xpath("//div[contains(@class,'error')]/h3");


    public LoginPage(WebDriver driver){
            super(driver);
        }

        public void enterUsername(String text){
            WebElement username = driver.findElement(usernameField);
            username.clear();
            username.sendKeys(text);
        }

        public void enterPassword(String text){
            WebElement password  = driver.findElement(passwordField);
            password.clear();
            password.sendKeys(text);
        }

        public void clickLogin(){
            driver.findElement(loginButton).click();
        }

        public String getErrorMessage(){
            return driver.findElement(errorMessage).getText();
        }
}
