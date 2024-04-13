package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class MyAccountPage 
{
	WebDriver driver;
	ElementsUtils gElementsUtils = new ElementsUtils(driver);
	
	public MyAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInformation;
	
	public boolean editYourAccountInformationText()
	{
		return gElementsUtils.fetchTextUsinggetText(editYourAccountInformation).contains("Edit your account information");
		
	}
	
}
