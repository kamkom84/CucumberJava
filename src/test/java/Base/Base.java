package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	
	public Base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config"
																   +"\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();  //
		}
		
	}

	public WebDriver initializeBrowserAndOpenAppicationURL(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")){

			driver = new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.manage().deleteAllCookies();
		
		driver.navigate().to(prop.getProperty("url"));
		
		return driver;

	}

	
	
	
	
	
	
	
}






















