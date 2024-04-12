package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
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
	
	@FindBy(xpath = "//div[@id=\\\"search\\\"]//input")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@class=\\\"btn btn-default btn-lg\\")
	private WebElement searchButton;

	public void clickOnMyAccount()
	{
		myAccountDropdownMenu.click();
	}
	
	public void clickOnRegister()
	{
		register.click();
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void enterInSearchBox(String searchProductText) 
	{
		searchBox.sendKeys(searchProductText);
	}
	
	public void clickOnSearchButton() 
	{
		searchButton.click();

	}
	
}
