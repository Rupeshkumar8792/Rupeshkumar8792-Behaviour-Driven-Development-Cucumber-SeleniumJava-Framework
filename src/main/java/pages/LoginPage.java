package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
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
	
	public boolean getErrorText()
	{
		explicitWait();
		return errorMessage.getText().contains("Warning: No match for E-Mail Address and/or Password.");
	}
		
	public void explicitWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
	}
}
