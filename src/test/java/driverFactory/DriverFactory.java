package driverFactory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory 
{	
	static WebDriver driver = null;
	static Properties prop;
	
	public static WebDriver initializeBrowser(String browsername)
	{
		prop = ConfigReader.intializeProperties();
		
		if (browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browsername.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver  = new FirefoxDriver();
		}
		if (browsername.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		return driver;
		
	}
	
	public static  WebDriver getDriver()
	{
		return driver;
		
	}
	
}
