package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailID;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneNumber;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passoword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@value='1'][@name='newsletter']")
	private WebElement yesSuscribeButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyBTN;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBTN;
	
	@FindBy(xpath = "//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible'][text()='Warning: E-Mail Address is already registered!']")
	private WebElement failureMessage;

	
	public void enterFirstName(String firstNameText) 
	{
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastName.sendKeys(lastNameText);
	}
	
	public void enterEmailID(String emailIDText)
	{
		emailID.sendKeys(emailIDText);
	}
	
	public void enterTelephoneNumber(String telephoneNumberText) 
	{
		telephoneNumber.sendKeys(telephoneNumberText);
	}
	
	public void enterPassoword(String passwordText) 
	{
		passoword.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmpasswordText) 
	{
		confirmPassword.sendKeys(confirmpasswordText);
	}
	
	public void clickOnYesSuscribeButton() 
	{
		yesSuscribeButton.click();
	}

	public void clickOnPrivacyPolicyBTN() 
	{
		privacyPolicyBTN.click();
	}
	
	public void clickOnContinueBTN() 
	{
		continueBTN.click();
	}
	
	public String getSuccessMessage()
	{
		return successMessage.getText();
	}
	
	public String failureMessage()
	{
		return failureMessage.getText();
	}
}
