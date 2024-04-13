package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class RegisterPage 
{
	WebDriver driver;
	ElementsUtils gElementsUtils = new ElementsUtils(driver);
	
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
	
	@FindBy(xpath = "//input[@id=\"input-firstname\"]//following-sibling::div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameErrorText;
	
	@FindBy(xpath = "//input[@id=\"input-lastname\"]//following-sibling::div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameErrorText;
	
	@FindBy(xpath = "//input[@id=\"input-email\"]//following-sibling::div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailErrorText;
	
	@FindBy(xpath = "//input[@id=\"input-telephone\"]//following-sibling::div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneErrorText;
	
	@FindBy(xpath = "//input[@id=\"input-password\"]//following-sibling::div[text()='Password must be between 4 and 20 characters!']")
	private WebElement passwordErrorText;
	
	
	public void enterFirstName(String firstNameText) 
	{
		gElementsUtils.typeIntoTheInputBox(firstName, firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		gElementsUtils.typeIntoTheInputBox(lastName, lastNameText);
	}
	
	public void enterEmailID(String emailIDText)
	{
		gElementsUtils.typeIntoTheInputBox(emailID, emailIDText);
	}
	
	public void enterTelephoneNumber(String telephoneNumberText) 
	{
		gElementsUtils.typeIntoTheInputBox(telephoneNumber, telephoneNumberText);
	}
	
	public void enterPassoword(String passwordText) 
	{
		gElementsUtils.typeIntoTheInputBox(passoword, passwordText);
	}
	
	public void enterConfirmPassword(String confirmpasswordText) 
	{
		gElementsUtils.typeIntoTheInputBox(confirmPassword, confirmpasswordText);
	}
	
	public void clickOnYesSuscribeButton() 
	{
		gElementsUtils.clickOnWebElement(yesSuscribeButton);
	}

	public void clickOnPrivacyPolicyBTN() 
	{
		gElementsUtils.clickOnWebElement(privacyPolicyBTN);
	}
	
	public void clickOnContinueBTN() 
	{
		gElementsUtils.clickOnWebElement(continueBTN);
	}
	
	public String getSuccessMessage()
	{
		return gElementsUtils.fetchTextUsinggetText(successMessage);
	}
	
	public String failureMessage()
	{
		return gElementsUtils.fetchTextUsinggetText(failureMessage);
	}
	
	public String firstNameErrorText() 
	{
		return gElementsUtils.fetchTextUsinggetText(firstNameErrorText);
	}
	
	public String lastNameErrorText() 
	{
		return gElementsUtils.fetchTextUsinggetText(lastNameErrorText);
	}
	
	public String emailErrorText() 
	{
		return gElementsUtils.fetchTextUsinggetText(emailErrorText);
	}
	
	public String telephoneErrorText() 
	{
		return gElementsUtils.fetchTextUsinggetText(telephoneErrorText);
	}
	
	public String passwordErrorText() 
	{
		return gElementsUtils.fetchTextUsinggetText(passwordErrorText);
	}
}
