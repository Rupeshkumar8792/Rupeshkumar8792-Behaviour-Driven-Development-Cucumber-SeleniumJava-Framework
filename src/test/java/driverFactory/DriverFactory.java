package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{	
	static WebDriver driver = null;
	
	public static void initializeBrowser(String browsername)
	{
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
		
	}
	
	public static  WebDriver getDriver()
	{
		return driver;
		
	}
	
}
