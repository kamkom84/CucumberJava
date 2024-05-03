package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Base.Base;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginFeatureSteps extends Base{
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	AccountPage accountPage;
	
	public LoginFeatureSteps() {
		
		super();
		
	}
	
	@Before
	public void openBrowser() {
		
		driver = initializeBrowserAndOpenAppicationURL(prop.getProperty("browserName"));
		
	}
	
	@After
	public void closeBrowser() {
		
		driver.quit();
		
	}
			
///////////////////////////STEP DEFINITIONS//////////////////////////////	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		String currentURL = driver.getCurrentUrl();
	    Assert.assertEquals(currentURL, "https://tutorialsninja.com/demo/");
	    
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_user_name_and_password(String email, String password) throws InterruptedException {
		
		homePage = new HomePage(driver);
		loginPage = homePage.openLoginPage();		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		
		loginPage.clickOnLoginButton();
	    
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfSuccessfulLogin());
	    
	}
	
	@Then("user is not navigated to home page")
	public void user_is_not_navigated_to_home_page() {
	    
		Assert.assertTrue(loginPage.getDisplayStatusOfFailedLogin());
		
	}
	
	@Then("user receives an error message wrong credentials")
	public void user_receives_an_error_message_wrong_credentials() {
	    
		Assert.assertTrue(loginPage.getDisplayStatusOfFailedLogin());
		
	}

}


















