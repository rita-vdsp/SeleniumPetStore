package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductInteractions {
	
	private WebDriver driver;
	
	private WebElement searchBox;
	
	private WebElement searchBtn;
	
	private WebElement elementCheckout;
	
	private WebElement elementContinue;
	
	private WebElement elementConfirm;
	
	private final By txtSearch = By.xpath("//input[@name='keyword']");
	
	private final By btnSearh = By.xpath("//input[@name='searchProducts']");
	
	private final By btnCheckout = By.xpath("//a[normalize-space()='Proceed to Checkout']");
	
	private final By btnContinue = By.xpath("//input[@name='newOrder']");
	
	private final By btnConfirm = By.xpath("//a[normalize-space()='Confirm']");
	
	
	public ProductInteractions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String product) {
		
		searchBox = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(txtSearch));
		searchBox.sendKeys("Persian");
		
		searchBtn = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnSearh));
		searchBtn.click();
	}
	
	public void proceedToCheckout() {
		elementCheckout = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnCheckout));
		elementCheckout.click();
	}
	
	public void continueOrder() {
		elementContinue = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnContinue));
		elementContinue.click();
		
		elementConfirm = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(btnConfirm));
		elementConfirm.click();
	}

}
