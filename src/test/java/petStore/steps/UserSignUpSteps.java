package petStore.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.UserSignUp;
import configurations.BrowserConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSignUpSteps {
	
	private WebDriver driver;
	private UserSignUp userSignUp;
	
	@Given("I have Selenium using {string}")
	public void i_have_selenium_using(String browser) {
		driver = BrowserConfiguration.startBrowser(browser);
		userSignUp = new UserSignUp(driver);

	}

	@Given("I am at the Pet Store Register page")
	public void i_am_at_the_pet_store_register_page() {
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");

	}

	@When("I enter valid user and account information")
	public void i_enter_valid_user_and_account_information() {
		userSignUp.insertUserInformation();
		userSignUp.insertAccountInformation();

	}

	@When("I click on Save Account")
	public void i_click_on_save_account() {
		userSignUp.clickSaveAccount();
	}

	@Then("I should be redirected from Register to the home page")
	public void i_should_be_redirected_from_register_to_the_home_page() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://petstore.octoperf.com/actions/Catalog.action"));
	}
	
	@After
	public void fecharNavedor() {
		BrowserConfiguration.closeBrowser();
	}
}
