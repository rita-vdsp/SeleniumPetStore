package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserSignIn {
	private WebDriver driver;
	
	private WebElement elementSignIn;
	
	private WebElement elementUserid;
	
	private WebElement elementPassword;
	
	private final By btnSignIn = By.xpath("//input[@name='signon']");
	
	private final By txtUserid = By.xpath("//input[@name='username']");
	
	private final By txtPassword = By.xpath("//input[@name='password']");
	
	public UserSignIn(WebDriver driver) {
		this.driver = driver;
	}

	public void userSignIn(String UserName, String userPassword) {
		
		elementUserid = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtUserid));
		elementUserid.clear();
		// String userId = generateUniqueUserId();
		elementUserid.sendKeys(UserName);

		elementPassword = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(txtPassword));
		elementPassword.clear();
		elementPassword.sendKeys(userPassword);
	}
	
	public void signInBtnClick() {
		elementSignIn = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(btnSignIn));
		elementSignIn.click();
	}
}
