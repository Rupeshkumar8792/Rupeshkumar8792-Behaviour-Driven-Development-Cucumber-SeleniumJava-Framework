package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;


public class MyHooks 
{
	WebDriver driver;
	Properties prop;
	@Before 
	public void setUp()
	{
		prop = ConfigReader.intializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("url"));
	}
	
	@After 
	public void tearDown()
	{
		driver.quit();
	}
}
