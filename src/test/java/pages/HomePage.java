package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    private final By homePage = By.xpath("//span[@class='title']");
    private final By hamburgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By filterDropDown = By.xpath("//select[@class='product_sort_container']");
    private final By product = By.xpath("//div[contains(@class,'inventory_item_name')]");
    private final By allProduct = By.xpath("//a[@id='inventory_sidebar_link']");
    private final By viewCart = By.xpath("//a[@class='shopping_cart_link']");
    private final By closeIcon = By.xpath("//button[@id='react-burger-cross-btn']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean isElementDisplayed() {
        WebElement e = driver.findElement(homePage);
        return e.isDisplayed();
    }
    public void clickOnProduct(){
        driver.findElement(product).click();
    }
    public void productFilter(String filter){
        Select dropDown = new Select(driver.findElement(filterDropDown));
        dropDown.selectByValue(filter);
    }
    public void clickHamburgerMenu(){
        driver.findElement(hamburgerMenu).click();
    }
    public void clickAllProduct(){
        driver.findElement(allProduct).click();
    }
    public void clickViewCart(){
        driver.findElement(viewCart).click();
    }
    public void clickClose(){
        driver.findElement(closeIcon).click();
    }

}
