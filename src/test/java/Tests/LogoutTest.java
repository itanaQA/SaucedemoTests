package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void userCanLogOut() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.hamburgerMenuClick();
        productsPage.menuOptionSelection("Logout");

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertFalse(elementIsDisplayed(productsPage.cartIcon));
    }


}
