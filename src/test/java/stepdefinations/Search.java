package stepdefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search
{
	DriverFactory gDriverFactory = new DriverFactory();
	WebDriver driver = gDriverFactory.getDriver();
	HomePage gHomePage = new HomePage(driver);
	SearchResultPage 	gSearchResultPage = new SearchResultPage(driver);
	
	@Given("user launchs the application")
	public void user_launchs_the_application() 
	{
	  
	}

	@When("User enter the valid product {string} into the search bar")
	public void user_enter_the_valid_product_into_the_search_bar(String productName) 
	{
		gHomePage.enterInSearchBox(productName);
	    
	}
	
	@When("User enter the invalid product {string} into the search bar")
	public void user_enter_the_invalid_product_into_the_search_bar(String invalidProductName) 
	{
		gHomePage.enterInSearchBox(invalidProductName);
	}

	@When("user clicks on the search Button")
	public void user_clicks_on_the_search_button() 
	{
		gHomePage.clickOnSearchButton();
	}

	@Then("user should be able to view the HP product")
	public void user_should_be_able_to_view_the_hp_product() 
	{
		Assert.assertTrue(gSearchResultPage.validHPProduct());
	}

	@Then("user should be able to view the appropriate message")
	public void user_should_be_able_to_view_the_appropriate_message() 
	{
	   Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed());
	}
	
	@Then("user should be able to view the no product matching message")
	public void user_should_be_able_to_view_the_no_product_matching_message()
	{
		Assert.assertEquals(gSearchResultPage.invalidProductErrorMessage(), "There is no product that matches the search criteria.");
	}

	@When("User does not enter the any product into the search bar")
	public void user_does_not_enter_the_any_product_into_the_search_bar() 
	{
		gHomePage = new HomePage(driver);

	}
}
