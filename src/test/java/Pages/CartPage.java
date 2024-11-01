package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item")
    public List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public List<WebElement> itemRemoveButton;

    @FindBy(css = ".inventory_item_name")
    public WebElement inventoryItemName;

    @FindBy( css = ".cart_item")
    public WebElement itemInCart;

    //----------------------------------------------------------------------------------


    public void clickOnContinueShoppingButton() {

        continueShoppingButton.click();

    }


    public void clickOnCheckoutButton() {

        checkoutButton.click();

    }

    public int countCartItems() {
        return cartItems.size();
    }


    public void removeAllItemsFromCart(){

        while (!itemRemoveButton.isEmpty()) {
            itemRemoveButton.get(0).click();

        }


    }




}
