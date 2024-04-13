package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
import utils.ElementsUtils;

public class LoginPage 
{
	WebDriver driver;
	Properties prop = ConfigReader.intializeProperties();
	
	ElementsUtils gElementsUtils = new ElementsUtils(driver);
	
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
	
	@FindBy(xpath ="//*[@id='account-login']/div[1]")
	private WebElement errorMessage;
	
	public void enterEmailId(String emailID) 
	{
		gElementsUtils.typeIntoTheInputBox(emailId, emailID);
	}
	
	public void enterPassword(String ppassword) 
	{
		gElementsUtils.typeIntoTheInputBox(password, ppassword);

	}
	
	public void clickOnLoginButton()
	{
		gElementsUtils.clickOnWebElement(loginBTN);

	}
	
	public String  getErrorText()
	{
		return gElementsUtils.fetchTextUsinggetText(errorMessage);
	}
		
	
}
