package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;




public class CheckoutProcessTest extends BaseTest {


    @Test
    public void userCanPlaceAnOrder() {
        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        String productName = excelReader.getStringData("Products", 1, 0);
        String productName1 = excelReader.getStringData("Products", 4, 0);
        String productName2 = excelReader.getStringData("Products", 3, 0);

        String firstName = excelReader.getStringData("TestData", 1, 2);
        String lastname = excelReader.getStringData("TestData", 1, 3);
        String postalCode = excelReader.getStringData("TestData", 1, 4);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(productName);
        productsPage.addItemByName(productName1);
        productsPage.addItemByName(productName2);
        productsPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.inputFirstName(firstName);
        checkoutInformationPage.inputLastName(lastname);
        checkoutInformationPage.inputPostalCode(postalCode);
        checkoutInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");



    }

    @Test
    public void userCanBeRedirectedToHomepageAfterPlacingAnOrder() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        String productName = excelReader.getStringData("Products", 1, 0);
        String productName1 = excelReader.getStringData("Products", 4, 0);

        String firstName = excelReader.getStringData("TestData", 1, 2);
        String lastname = excelReader.getStringData("TestData", 1, 3);
        String postalCode = excelReader.getStringData("TestData", 1, 4);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(productName);
        productsPage.addItemByName(productName1);
        productsPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.inputFirstName(firstName);
        checkoutInformationPage.inputLastName(lastname);
        checkoutInformationPage.inputPostalCode(postalCode);
        checkoutInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnFinishButton();
        checkoutCompletePage.clickOnBackToProducts();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productsPage.hamburgerMenu.isDisplayed());

    }

    @Test
    public void userCannotPlaceAnOrderWithoutMandatoryInformation() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        String productName = excelReader.getStringData("Products", 1, 0);
        String productName1 = excelReader.getStringData("Products", 4, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(productName);
        productsPage.addItemByName(productName1);
        productsPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.inputFirstName("");
        checkoutInformationPage.inputLastName("");
        checkoutInformationPage.inputPostalCode("");
        checkoutInformationPage.clickOnContinueButton();

        Assert.assertTrue(checkoutInformationPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

    }

    @Test
    public void userCanCancelOrderFromCheckoutInformationPage() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        String productName = excelReader.getStringData("Products", 1, 0);
        String productName1 = excelReader.getStringData("Products", 4, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(productName);
        productsPage.addItemByName(productName1);
        productsPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.clickOnCancelButton();

        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());
        Assert.assertFalse(elementIsDisplayed(checkoutInformationPage.cancelButton));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

    }


    @Test
    public void userCanCancelOrderFromCheckoutOverviewPage() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        String productName = excelReader.getStringData("Products", 1, 0);
        String productName1 = excelReader.getStringData("Products", 4, 0);

        String firstName = excelReader.getStringData("TestData", 1, 2);
        String lastname = excelReader.getStringData("TestData", 1, 3);
        String postalCode = excelReader.getStringData("TestData", 1, 4);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(productName);
        productsPage.addItemByName(productName1);
        productsPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutInformationPage.inputFirstName(firstName);
        checkoutInformationPage.inputLastName(lastname);
        checkoutInformationPage.inputPostalCode(postalCode);
        checkoutInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnCancelButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productsPage.hamburgerMenu.isDisplayed());


    }


}