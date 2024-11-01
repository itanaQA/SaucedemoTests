package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage extends BaseTest {

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;


//----------------------------------------------------------------

    public void clickOnBackToProducts() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        this.backToProductsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
        backToProductsButton.click();

    }




}
