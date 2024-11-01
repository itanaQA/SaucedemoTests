package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public CartPage cartPage;
    public CheckoutInformationPage checkoutInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CheckoutCompletePage checkoutCompletePage;

    public ExcelReader excelReader;

    @BeforeMethod
    public void pageSetUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com");

        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();


        excelReader = new ExcelReader("UserData.xlsx");


    }

    public boolean elementIsDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDisplayed;
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }






}







