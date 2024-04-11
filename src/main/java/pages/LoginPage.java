package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBTN;
	
	@FindBy
	private WebElement errorMessage;
	
	public void enterEmailId(String emailID) 
	{
		emailId.sendKeys(emailID);
	}
	
	public void enterPassword(String ppassword) 
	{
		password.sendKeys(ppassword);
	}
	
	public void clickOnLoginButton()
	{
		loginBTN.click();
	}
	
	public String getErrorText()
	{
		return errorMessage.getText();
	}
		
}
