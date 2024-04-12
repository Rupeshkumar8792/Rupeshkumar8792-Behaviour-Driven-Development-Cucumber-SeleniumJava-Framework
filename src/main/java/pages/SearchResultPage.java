package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage 
{
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "HP LP3065")
	public WebElement validHPProduct;
	
	@FindBy(xpath = "//input[@id=\"button-search\"]//following-sibling::p")
	private WebElement invalidProductErrorMessage;
	
	public boolean validHPProduct() 
	{
		return validHPProduct.isDisplayed();
	}
	
	public String  invalidProductErrorMessage() 
	{
		System.out.println(invalidProductErrorMessage.getText());
		return invalidProductErrorMessage.getText();
	}
}
