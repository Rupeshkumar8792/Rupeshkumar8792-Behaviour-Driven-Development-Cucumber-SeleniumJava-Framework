package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class AccountSuccessPage 
{
	WebDriver driver;
	ElementsUtils gElementsUtils = new ElementsUtils(driver);
	
	public AccountSuccessPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	private WebElement successMessageHeading;
	
	public String getSuccessMessage()
	{
		return gElementsUtils.fetchTextUsinggetText(successMessageHeading);
	}
}
