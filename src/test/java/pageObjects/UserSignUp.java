package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Utils;

public class UserSignUp {
	
	private WebDriver driver;

	private WebElement userId;

	private WebElement newPassword;

	private WebElement repeatNewPassword;

	private WebElement firstName;

	private WebElement lastName;

	private WebElement email;

	private WebElement phone;

	private WebElement firstAddress;

	private WebElement city;

	private WebElement state;

	private WebElement zip;

	private WebElement country;

	private WebElement buttonSave;

	private final By txtUserId = By.xpath("//input[@name='username']");

	private final By txtNewPassword = By.xpath("//input[@name='password']");

	private final By txtRepeatNewPassword = By.xpath("//input[@name='repeatedPassword']");

	private final By txtFirstName = By.xpath("//input[@name='account.firstName']");

	private final By txtLastName = By.xpath("//input[@name='account.lastName']");

	private final By txtEmail = By.xpath("//input[@name='account.email']");

	private final By txtPhone = By.xpath("//input[@name='account.phone']");

	private final By txtFirstAdress = By.xpath("//input[@name='account.address1']");

	private final By txtCity = By.xpath("//input[@name='account.city']");

	private final By txtState = By.xpath("//input[@name='account.state']");

	private final By txtZip = By.xpath("//input[@name='account.zip']");

	private final By txtCountry = By.xpath("//input[@name='account.country']");

	private final By btnSaveAccount = By.xpath("//input[@name='newAccount']");

	public UserSignUp(WebDriver driver) {
		this.driver = driver;
	}

	public void insertUserInformation() {

		userId = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtUserId));
		userId.clear();
		String user = Utils.generateRandomUser();
		userId.sendKeys(user);

		newPassword = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtNewPassword));
		newPassword.clear();
		newPassword.sendKeys("pass_1091");

		repeatNewPassword = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtRepeatNewPassword));
		repeatNewPassword.clear();
		repeatNewPassword.sendKeys("pass_1091");

	}

	public void insertUserInformationInput(String newUserName, String newUserPassword) {

		userId = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtUserId));
		userId.clear();
		
		userId.sendKeys(newUserName);

		newPassword = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtNewPassword));
		newPassword.clear();
		newPassword.sendKeys(newUserPassword);

		repeatNewPassword = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtRepeatNewPassword));
		repeatNewPassword.clear();
		repeatNewPassword.sendKeys(newUserPassword);

	}

	public void insertAccountInformation() {
		firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtFirstName));
		firstName.clear();
		firstName.sendKeys(Utils.getUserFirstName());

		lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtLastName));
		lastName.clear();
		lastName.sendKeys(Utils.getUserLastName());

		email = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtEmail));
		email.clear();
		email.sendKeys("user_test@example.com");

		phone = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtPhone));
		phone.clear();
		phone.sendKeys("123456789");

		firstAddress = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtFirstAdress));
		firstAddress.clear();
		firstAddress.sendKeys("Rua Test 123");

		city = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtCity));
		city.clear();
		city.sendKeys("Porto");

		state = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtState));
		state.clear();
		state.sendKeys("Porto");

		zip = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(txtZip));
		zip.clear();
		zip.sendKeys("4000");

		country = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtCountry));
		country.clear();
		country.sendKeys("Portugal");
	}

	public void insertAccountInformation(String newUserName) {
		firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtFirstName));
		firstName.clear();
		firstName.sendKeys(Utils.getUserFirstName(newUserName));

		lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtLastName));
		lastName.clear();
		lastName.sendKeys(Utils.getUserLastName(newUserName));

		email = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtEmail));
		email.clear();
		email.sendKeys("user_test@example.com");

		phone = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtPhone));
		phone.clear();
		phone.sendKeys("123456789");

		firstAddress = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtFirstAdress));
		firstAddress.clear();
		firstAddress.sendKeys("Rua Test 123");

		city = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtCity));
		city.clear();
		city.sendKeys("Porto");

		state = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtState));
		state.clear();
		state.sendKeys("Porto");

		zip = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(txtZip));
		zip.clear();
		zip.sendKeys("4000");

		country = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtCountry));
		country.clear();
		country.sendKeys("Portugal");
	}

	public void insertProfileInformation() {

	}

	public void clickSaveAccount() {
		buttonSave = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnSaveAccount));
		buttonSave.click();
	}

	public void RegisterUser(String newUserName, String newUserPassword) {

		insertUserInformationInput(newUserName, newUserPassword);
		insertAccountInformation(newUserName);
		clickSaveAccount();

	}
}
