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
	
	public void explicitWaitForClickableItems(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Alert explicitWaitForAlerts()
	{
		Alert alert = null;
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		return alert;
	}
	
	public void explicitWaitForVisibilityOfWebElements(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickOnWebElement(WebElement element)
	{
		explicitWaitForClickableItems(element);
		element.click();
	}
	
	public void typeIntoTheInputBox(WebElement element,String inputValue)
	{
		explicitWaitForClickableItems(element);
		element.click();
		element.clear();
		element.sendKeys(inputValue);
	}
	
	public void selectOptionFromDropdown(WebElement element,String inputValue) 
	{
		explicitWaitForClickableItems(element);
		Select objSelect = new Select(element);
		objSelect.selectByVisibleText(inputValue);
	}
	
	public void acceptAlert() 
	{
		Alert alert =explicitWaitForAlerts();
		alert.accept();
	}
	
	public void dismissAlert() 
	{
		Alert alert =explicitWaitForAlerts();
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element) 
	{
		explicitWaitForVisibilityOfWebElements(element);
		Actions objActions = new Actions(driver);
		objActions.moveToElement(element).build().perform();
	}
	
	public void javascriptExecutorClick(WebElement element)
	{
		explicitWaitForVisibilityOfWebElements(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void javascriptExecutorTypeInInputBox(WebElement element,String inputValue)
	{
		explicitWaitForVisibilityOfWebElements(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+inputValue+"'", element);
	}
	
	public String fetchTextUsinggetText(WebElement element)
	{
		explicitWaitForVisibilityOfWebElements(element);
		return element.getText();
	}
}
