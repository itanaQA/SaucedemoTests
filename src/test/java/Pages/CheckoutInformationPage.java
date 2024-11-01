package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage extends BaseTest {

    public CheckoutInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodefield;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    //----------------------------------------------------------------


    public void inputFirstName(String firstName) {

        firstNameField.clear();
        firstNameField.sendKeys(firstName);

    }

    public void inputLastName(String lastName) {

        lastNameField.clear();
        lastNameField.sendKeys(lastName);

    }

    public void inputPostalCode(String postalCode) {

        postalCodefield.clear();
        postalCodefield.sendKeys(postalCode);

    }

    public void clickOnCancelButton() {

        cancelButton.click();

    }

    public void clickOnContinueButton() {

        continueButton.click();

    }


}
