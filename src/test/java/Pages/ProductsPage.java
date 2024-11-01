package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(css = ".inventory_item_price")
    public List<WebElement> productPrices;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> removeFromCartButton;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartFromProduct;

    @FindBy(id = "remove")
    public WebElement removeFromCartFromProduct;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartIcon;

    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartItemCount;

    @FindBy(css = ".product_sort_container")
    public WebElement sortDropdown;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(css = ".bm-item.menu-item")
    public List<WebElement> hamburgerMenuOptions;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy (css = ".inventory_details_name.large_size")
    public  WebElement inventoryItemDetails;


//-------------------------------------------------------------------------------------


    public void addAllProductsToCart() {

        for (int i = addToCartButtons.size() - 1; i >= 0; i--) {
            addToCartButtons.get(i).click();

        }
    }

    public void selectItemByName(String itemName) {

        for (int i = 0; i < productNames.size(); i++) {

            if (productNames.get(i).getText().equalsIgnoreCase((itemName))) {
                productNames.get(i).click();
                break;
            }
        }
    }

    public List<String> getProductNames() {
        List<WebElement> productElements = productNames;
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productElements) {
            productNames.add(product.getText().trim());
        }

        return productNames;
    }

    public void addItemByName(String itemName) {
        for (int i = productNames.size() - 1; i >= 0; i--) {
            if (addToCartButtons.size() > i && productNames.get(i).getText().equalsIgnoreCase(itemName)) {
                addToCartButtons.get(i).click();
                break;
            }
        }
    }

    public void removeAllProductsFromCart() {

        for (int i = removeFromCartButton.size() - 1; i >= 0; i--) {
            removeFromCartButton.get(i).click();

        }
    }

    public void addProductToCartFromProductDetailsPage(){

        addToCartFromProduct.click();

    }

    public void removeProductToCartFromProductDetailsPage(){

        removeFromCartFromProduct.click();

    }

    private List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    public boolean arePricesSortedLowToHigh() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        return prices.equals(sortedPrices);
    }


    public void hamburgerMenuClick() {

        hamburgerMenu.click();
    }

    public void menuOptionSelection(String menuItemName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        for (int i = 0; i < hamburgerMenuOptions.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(hamburgerMenuOptions.get(i)));
            if (hamburgerMenuOptions.get(i).getText().equals(menuItemName)) {
                hamburgerMenuOptions.get(i).click();
                break;
            }
        }
    }

    public int cartBadgeNumber() {

        return Integer.parseInt(cartItemCount.getText());

    }

    public void selectSortOption(String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue(value);
    }

    public boolean productsAreSortedAlphabetically() {
        List<String> productNames = getProductNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);
        return productNames.equals(sortedNames);
    }

    public void clickOnCartIcon() {

        cartIcon.click();

    }


    public void goBackToProductsButton() {

        backToProductsButton.click();

    }

}

