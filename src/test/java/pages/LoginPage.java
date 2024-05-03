package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement failedLoginAttemptMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement wrongCredentialsMessage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.click();
		emailAddressField.clear();
		emailAddressField.sendKeys(emailText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnLoginButton() throws InterruptedException {
		
		Thread.sleep(2000);
		loginButton.click();
		
		return new AccountPage(driver);
		
	}
	
	public boolean getDisplayStatusOfFailedLogin() {
		
		boolean displayStatus = failedLoginAttemptMessage.isDisplayed();
		return displayStatus;
		
	}
	
	
	public boolean getDisplayedStatusOfWrongCredentials() {
		
	
		boolean displayStatus = wrongCredentialsMessage.isDisplayed();
		return displayStatus;	
	}
	
	
	
	
	

}


























