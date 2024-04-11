package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInformation;
	
	public boolean editYourAccountInformationText()
	{
		return editYourAccountInformation.getText().contains("Edit your account information");
	}
	
}
