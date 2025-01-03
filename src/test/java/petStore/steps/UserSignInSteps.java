package petStore.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.UserSignIn;
import configurations.BrowserConfiguration;
import configurations.Utils;
import pageObjects.UserSignUp;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSignInSteps {
	
	private static WebDriver driver;
	private static UserSignUp userSignUp;
	private static UserSignIn userSignIn;
	private static String userNameTest = Utils.generateRandomUser();
	private final static String userPassTest = "Pass_123";
	
	@BeforeAll
	public static void creatUserTest() {
		driver = BrowserConfiguration.startBrowser("chrome");
		userSignUp = new UserSignUp(driver);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		userSignUp.RegisterUser(userNameTest,userPassTest );
		BrowserConfiguration.closeBrowser();
	}
	
	@Given("I have Selenium using {string} for login")
	public void i_have_selenium_using_for_login(String browser) {
		driver = BrowserConfiguration.startBrowser(browser);
		userSignUp = new UserSignUp(driver);
		userSignIn = new pageObjects.UserSignIn(driver);

	}
	
	@Given("I am at the Pet Store Login page")
	public void i_am_at_the_pet_store_login_page() {
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}

	@When("I enter a valid username and password")
	public void i_enter_a_valid_username_and_password() {
		String userTest = userNameTest;
		userSignIn.userSignIn(userTest, userPassTest);
	}

	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		userSignIn.signInBtnClick();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equals("https://petstore.octoperf.com/actions/Catalog.action"));
	}
	
	@After
	public void fecharNavedor() {
		BrowserConfiguration.closeBrowser();
	}
}
