package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage 
{
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	private WebElement successMessageHeading;
	
	public String getSuccessMessage()
	{
		return successMessageHeading.getText();
	}
}
