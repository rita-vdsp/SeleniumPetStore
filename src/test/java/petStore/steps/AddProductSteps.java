package petStore.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.BrowserConfiguration;
import pageObjects.ProductInteractions;
import pageObjects.UserSignIn;
import pageObjects.UserSignUp;
import configurations.Utils;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;

public class AddProductSteps {
	
	
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
	
	private WebElement elementShoppingCart;
	private final By txtShoppingCart = By.xpath("//h2[normalize-space()='Shopping Cart']");
	
	private WebElement catImage;
	private final By imgCat = By.xpath("//a[normalize-space()='Friendly house cat, doubles as a princess']");
	
	//private WebElement elementQuantityCart;
	//private final By txtQuantityCart = By.xpath("//input[@name='EST-17']");
	
	@BeforeAll
	public static void creatUserTest() {
		driver = BrowserConfiguration.startBrowser("chrome");
		userSignUp = new UserSignUp(driver);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		userSignUp.RegisterUser(userNameTest,userPassTest );
		BrowserConfiguration.closeBrowser();
	}
	
	@Given("I have Selenium using {string} to add product")
	public void i_have_selenium_using_to_add_product(String browser) {
		driver = BrowserConfiguration.startBrowser(browser);
		userSignUp = new UserSignUp(driver);
		userSignIn = new pageObjects.UserSignIn(driver);
		productInt = new ProductInteractions(driver);
	}
	
	@Given("I am login into the website")
	public void i_am_login_into_the_website() {
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		String userTest = userNameTest;
		userSignIn.userSignIn(userTest, userPassTest);
		userSignIn.signInBtnClick();
	}
	
	@Given("I research my product")
	public void i_research_my_product() {
		productInt.searchProduct("Persian");
		catImage = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(imgCat));
		catImage.click();
	}
	
	@Given("I add a product to my Cart")
	public void I_add_a_product_to_my_Cart() {
		elementProductLink = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnProductLink));
		elementProductLink.click();
    	
    	elementAddMaleCatToCart = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnAddMaleCatToCart));
    	elementAddMaleCatToCart.click();
    	
    	
	}
	
	@Given("I should have the product in my cart")
	public void I_should_have_the_product_in_my_cart() {
		elementShoppingCart = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.visibilityOfElementLocated(txtShoppingCart));

		String txtPage = elementShoppingCart.getText();
		Assert.assertEquals("Shopping Cart", txtPage);
	}
	
	@After
	public void fecharNavedor() {
		BrowserConfiguration.closeBrowser();
	}
}
