package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CompleteOrderTest extends BaseTest{
    private final String standardUser = "standard_user";
    private final String password = "secret_sauce";

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SuccessfulOrderPage successfulOrderPage = new SuccessfulOrderPage(driver);

        loginPage.enterUsername(standardUser);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(homePage.isElementDisplayed(),"Unsuccessful Login");

        homePage.productFilter("za");
        homePage.clickHamburgerMenu();
        homePage.clickAllProduct();
        homePage.clickClose();
        homePage.clickOnProduct();

        productDetailsPage.clickAddToCart();
        productDetailsPage.backToProduct();

        homePage.clickViewCart();
        viewCartPage.checkout();
        checkoutPage.addAddressDetails("Saiful","Islam","124D");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(successfulOrderPage.successMessage(),
                "Thank you for your order!","Product order is not successful");
        successfulOrderPage.clickBackButton();

    }
}
