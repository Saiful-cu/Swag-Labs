package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CompleteOrderTest extends BaseTest {
    private final String standardUser = "standard_user";
    private final String password = "secret_sauce";

    @Test(priority = 1)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterUsername(standardUser);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(homePage.isElementDisplayed(), "Unsuccessful Login");
    }

    @Test(priority = 2)
    public void testProductFilter() {
        HomePage homePage = new HomePage(driver);
        homePage.productFilter("za");
        Assert.assertTrue(homePage.isSortedZtoA(), "The product sorting is not correct");
    }

    @Test(priority = 3)
    public void testHamburgerMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickHamburgerMenu();
        homePage.clickClose();
        Assert.assertTrue(homePage.isElementDisplayed(), "The hamburger is not close");
    }

    @Test(priority = 4)
    public void testProductDetails() {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        homePage.clickOnProduct();
        productDetailsPage.clickAddToCart();
        productDetailsPage.backToProduct();
        Assert.assertTrue(homePage.isElementDisplayed(), "The Back button is not working");
    }

    @Test(priority = 5)
    public void testCartPage() {
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickViewCart();
        Assert.assertTrue(viewCartPage.isCartPageDisplayed(), "Cart Page is not Displayed");
    }

    @Test(priority = 6)
    public void testCheckout() {
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SuccessfulOrderPage successfulOrderPage = new SuccessfulOrderPage(driver);
        HomePage homePage = new HomePage(driver);
        viewCartPage.checkout();
        checkoutPage.addAddressDetails("Saiful", "Islam", "124D");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        Assert.assertEquals(successfulOrderPage.successMessage(), "Thank you for your order!", "Product order is not successful");

        successfulOrderPage.clickBackButton();
        Assert.assertTrue(homePage.isElementDisplayed(), "The hamburger is not close");

    }
}
