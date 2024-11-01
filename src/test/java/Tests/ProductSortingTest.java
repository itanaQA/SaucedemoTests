package Tests;

import Base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;



public class ProductSortingTest extends BaseTest {


    @Test
    public void userCanSortItemsFromAToZ (){

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectSortOption("az");

        Assert.assertTrue(productsPage.productsAreSortedAlphabetically());


    }

    @Test
    public void userCanSortItemsFromZToA (){

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectSortOption("za");

        Assert.assertFalse(productsPage.productsAreSortedAlphabetically());


    }

    @Test
    public void userCanSortItemsFromLowToHigh (){

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectSortOption("lohi");

        Assert.assertTrue(productsPage.arePricesSortedLowToHigh());

    }

    @Test
    public void userCanSortItemsFromHighToL (){

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectSortOption("hilo");

        Assert.assertFalse(productsPage.arePricesSortedLowToHigh());


    }






}
