package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {


    @Test
    public void userCanRemoveAllProductsFromTheCart() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);


        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();
        productsPage.clickOnCartIcon();
        cartPage.removeAllItemsFromCart();


        Assert.assertFalse(elementIsDisplayed(productsPage.cartItemCount));
        Assert.assertTrue(cartPage.itemRemoveButton.isEmpty());


    }

    @Test
    public void userCanAddProductsToCart() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();
        productsPage.clickOnCartIcon();

        int numberOfItemsInCart = productsPage.cartBadgeNumber();
        Assert.assertEquals(numberOfItemsInCart, 6);
        Assert.assertTrue(cartPage.itemInCart.isDisplayed());


    }


    @Test
    public void userCanContinueShoppingFromCart() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();
        productsPage.clickOnCartIcon();
        cartPage.clickOnContinueShoppingButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productsPage.hamburgerMenu.isDisplayed());


    }

    @Test
    public void cartStateIsSavedAfterUserLogsOutAndLogsInAgain() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();
        productsPage.cartBadgeNumber();
        int numberOfItemsInCart = productsPage.cartBadgeNumber();

        productsPage.hamburgerMenuClick();
        productsPage.menuOptionSelection("Logout");

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        driver.navigate().refresh();

        int numberOfItemsInCartAfterLogout = productsPage.cartBadgeNumber();
        Assert.assertEquals(numberOfItemsInCart, numberOfItemsInCartAfterLogout);

        productsPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.itemInCart.isDisplayed());

    }


}
