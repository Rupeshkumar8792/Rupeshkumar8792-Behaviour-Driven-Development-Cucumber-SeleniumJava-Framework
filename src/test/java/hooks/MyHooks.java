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
		driver = DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
	}
	
	@After 
	public void tearDown()
	{
		driver.quit();
	}
}
