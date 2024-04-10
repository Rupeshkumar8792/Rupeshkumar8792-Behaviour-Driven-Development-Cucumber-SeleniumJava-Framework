package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class MyHooks 
{
	WebDriver driver;
	@Before 
	public void setUp()
	{
		DriverFactory.initializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@After 
	public void tearDown()
	{
		driver.quit();
	}
}
