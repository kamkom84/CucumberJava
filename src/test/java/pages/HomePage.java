package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement dropdownMenu;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public LoginPage openLoginPage() {
		
		dropdownMenu.click();
		loginButton.click();
		
		return new LoginPage(driver);
	}
	
	
	
	
	
	
	
	
	
	

}
