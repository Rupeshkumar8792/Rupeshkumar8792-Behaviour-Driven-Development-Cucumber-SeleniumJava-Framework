package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils 
{
	WebDriver driver;
	
	public ElementsUtils(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explicitWaitForClickableItems(WebElement element, long DurationInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Alert explicitWaitForAlerts(long DurationInSeconds)
	{
		Alert alert = null;
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(DurationInSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		return alert;
	}
	
	public void explicitWaitForVisibilityOfWebElements(WebElement element, long DurationInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(DurationInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickOnWebElement(WebElement element, long DurationInSeconds)
	{
		explicitWaitForClickableItems(element, DurationInSeconds);
		element.click();
	}
	
	public void typeIntoTheInputBox(WebElement element, long DurationInSeconds,String inputValue)
	{
		explicitWaitForClickableItems(element,DurationInSeconds);
		element.click();
		element.clear();
		element.sendKeys(inputValue);
	}
	
	public void selectOptionFromDropdown(WebElement element, long DurationInSeconds,String inputValue) 
	{
		explicitWaitForClickableItems(element,DurationInSeconds);
		Select objSelect = new Select(element);
		objSelect.selectByVisibleText(inputValue);
	}
	
	public void acceptAlert(long DurationInSeconds) 
	{
		Alert alert =explicitWaitForAlerts(DurationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long DurationInSeconds) 
	{
		Alert alert =explicitWaitForAlerts(DurationInSeconds);
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element, long DurationInSeconds) 
	{
		explicitWaitForVisibilityOfWebElements(element, DurationInSeconds);
		Actions objActions = new Actions(driver);
		objActions.moveToElement(element).build().perform();
	}
	
	public void javascriptExecutorClick(WebElement element, long DurationInSeconds)
	{
		explicitWaitForVisibilityOfWebElements(element, DurationInSeconds);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void javascriptExecutorTypeInInputBox(WebElement element, long DurationInSeconds,String inputValue)
	{
		explicitWaitForVisibilityOfWebElements(element, DurationInSeconds);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+inputValue+"'", element);
	}
}
