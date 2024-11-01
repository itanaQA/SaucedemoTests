package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAuthenticationTest extends BaseTest {


    @Test
    public void UserCanLogInWithValidCredentials() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productsPage.cartIcon.isDisplayed());

    }

    @Test
    public void UserCannotLogInWithInvalidUsername() {

        String invalidUsername = excelReader.getStringData("TestData", 2, 0);
        String password = excelReader.getStringData("TestData", 2, 1);

        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test
    public void UserCannotLogInWithInvalidPassword() {

        String username = excelReader.getStringData("TestData", 3, 0);
        String invalidPassword = excelReader.getStringData("TestData", 3, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test
    public void UserCannotLogInWithEmptyCredentials() {

        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test
    public void UserCannotLogInWithEmptyUsernameField() {

        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername("");
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @Test
    public void UserCannotLogInWithEmptyPasswordField() {

        String username = excelReader.getStringData("TestData", 1, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }



}
