package hooks;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;


public class MyHooks 
{
	WebDriver driver;
	Properties prop;
	DriverFactory gDriverFactory;
	@Before 
	public void setUp()
	{
		prop = ConfigReader.intializeProperties();
		gDriverFactory = new DriverFactory();
		driver = gDriverFactory.initializeBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));
	}
	
	@After 
	public void tearDown(Scenario scenario)
	{
		String ScenarioName = scenario.getName().replace(" ", "_");
		if (scenario.isFailed())
		{
			byte[] image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(image, "image/png", ScenarioName);
		}
		driver.quit();
	}
}
