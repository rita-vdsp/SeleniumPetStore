package petStore.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.BrowserConfiguration;
import configurations.Utils;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.ProductInteractions;
import pageObjects.UserSignIn;
import pageObjects.UserSignUp;

public class BuyProductSteps {

	private static WebDriver driver;
	private static UserSignUp userSignUp;
	private static UserSignIn userSignIn;
	private static ProductInteractions productInt;
	private static String userNameTest = Utils.generateRandomUser();
	private final static String userPassTest = "Pass_123";
	
	private WebElement elementProductLink;
	private final By btnProductLink = By.linkText("EST-17");
	
	private WebElement elementAddMaleCatToCart;
	private final By btnAddMaleCatToCart = By.xpath("//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-17']");
	
	private WebElement catImage;
	private final By imgCat = By.xpath("//a[normalize-space()='Friendly house cat, doubles as a princess']");
	
	private WebElement elementOrderConfirmation;
	private final By txtOrderConfirmation = By.xpath("//ul[@class='messages']");
	
	
	@BeforeAll
	public static void creatUserTest() {
		driver = BrowserConfiguration.startBrowser("chrome");
		userSignUp = new UserSignUp(driver);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		userSignUp.RegisterUser(userNameTest,userPassTest );
		BrowserConfiguration.closeBrowser();
	}
	
	@Given("I have Selenium using {string} to buy product")
	public void i_have_selenium_using_to_buy_product(String browser) {
		driver = BrowserConfiguration.startBrowser(browser);
		userSignUp = new UserSignUp(driver);
		userSignIn = new pageObjects.UserSignIn(driver);
		productInt = new ProductInteractions(driver);
	}
	
	@Given("I am login in")
	public void i_am_login_in() {
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		String userTest = userNameTest;
		userSignIn.userSignIn(userTest, userPassTest);
		userSignIn.signInBtnClick();
	}
	
	@Given("I buy a product")
	public void i_buy_a_product() {
		productInt.searchProduct("Persian");
		catImage = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(imgCat));
		catImage.click();
		
		elementProductLink = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnProductLink));
		elementProductLink.click();
    	
    	elementAddMaleCatToCart = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnAddMaleCatToCart));
    	elementAddMaleCatToCart.click();
    	
    	productInt.proceedToCheckout();
    	productInt.continueOrder();
	}
	
	@Then("I should see an order confirmation")
	public void i_should_see_an_order_confirmation() {
		elementOrderConfirmation = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOfElementLocated(txtOrderConfirmation));

		String confirmationText = elementOrderConfirmation.getText();
		Assert.assertEquals("Thank you, your order has been submitted.", confirmationText);
	}
	
	@After
	public void fecharNavedor() {
		BrowserConfiguration.closeBrowser();
	}
}
