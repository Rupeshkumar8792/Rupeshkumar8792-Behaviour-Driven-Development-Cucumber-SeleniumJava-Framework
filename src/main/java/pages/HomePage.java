package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class HomePage 
{
	WebDriver driver;
	ElementsUtils gElementsUtils = new ElementsUtils(driver);
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropdownMenu;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount()
	{
		gElementsUtils.clickOnWebElement(myAccountDropdownMenu);
	}
	
	public void clickOnRegister()
	{
		gElementsUtils.clickOnWebElement(register);
		
	}
	
	public void clickOnLogin()
	{
		gElementsUtils.clickOnWebElement(login);
	}
	
	public void enterInSearchBox(String searchProductText) 
	{
		gElementsUtils.typeIntoTheInputBox(searchBox, searchProductText);
	}
	
	public void clickOnSearchButton() 
	{
		gElementsUtils.clickOnWebElement(searchButton);
	}
	
}
