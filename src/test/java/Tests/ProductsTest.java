package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {


    //User can remove an item from the cart via the product card “Remove” button - asertacije
    //User can view product details

    //User can add product to cart from the product page
    //User can remove product from cart from the product page


    @Test
    public void userCanAddAProductToCart() {


        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);
        String itemName = excelReader.getStringData("Products", 1, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addItemByName(itemName);

        int numberOfItemsInCart = productsPage.cartBadgeNumber();
        Assert.assertEquals(numberOfItemsInCart, 1);
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.inventoryItemName.getText(), itemName);
        Assert.assertEquals(cartPage.countCartItems(), numberOfItemsInCart);
    }


    @Test
    public void userCanAddMultipleProductsToCart() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();

        int numberOfItemsInCart = productsPage.cartBadgeNumber();
        Assert.assertEquals(numberOfItemsInCart, 6);
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.countCartItems(), numberOfItemsInCart);


    }


    @Test
    public void userCanRemoveItemFromCartFromProductRemoveButton() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.addAllProductsToCart();
        productsPage.removeAllProductsFromCart();

        Assert.assertFalse(elementIsDisplayed(productsPage.cartItemCount));
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.countCartItems(), 0);


    }

    @Test
    public void userCanViewProductDetails() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);
        String itemName = excelReader.getStringData("Products", 1, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectItemByName(itemName);

        String inventoryItemName = productsPage.inventoryItemDetails.getText();
        Assert.assertEquals(inventoryItemName, itemName);
        Assert.assertTrue(productsPage.backToProductsButton.isDisplayed());

    }

    @Test
    public void userCanAddProductFromProductsPage() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);
        String itemName = excelReader.getStringData("Products", 1, 0);


        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectItemByName(itemName);
        productsPage.addProductToCartFromProductDetailsPage();

        int numberOfItemsInCart = productsPage.cartBadgeNumber();
        Assert.assertEquals(numberOfItemsInCart, 1);
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.countCartItems(), numberOfItemsInCart);


    }

    @Test
    public void userCanRemoveProductFromProductsPage() {

        String username = excelReader.getStringData("TestData", 1, 0);
        String password = excelReader.getStringData("TestData", 1, 1);
        String itemName = excelReader.getStringData("Products", 1, 0);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        productsPage.selectItemByName(itemName);
        productsPage.addProductToCartFromProductDetailsPage();
        productsPage.removeProductToCartFromProductDetailsPage();

        Assert.assertFalse(elementIsDisplayed(productsPage.cartItemCount));
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.countCartItems(), 0);

    }


}
