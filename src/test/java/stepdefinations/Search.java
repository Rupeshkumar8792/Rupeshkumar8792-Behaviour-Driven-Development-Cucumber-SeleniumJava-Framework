package stepdefinations;
import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search
{
	WebDriver driver = DriverFactory.getDriver();
	
	@Given("user launchs the application")
	public void user_launchs_the_application() 
	{
	  
	}

	@When("User enter the valid product {string} into the search bar")
	public void user_enter_the_valid_product_into_the_search_bar(String string) 
	{
	    driver.findElement(By.xpath("//div[@id=\"search\"]//input")).sendKeys(string);
	}

	@When("user clicks on the search Button")
	public void user_clicks_on_the_search_button() 
	{
	   driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();
	}

	@Then("user should be able to view the HP product")
	public void user_should_be_able_to_view_the_hp_product() 
	{
	    Assert.assertEquals(true, driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@Then("user should be able to view the appropriate message")
	public void user_should_be_able_to_view_the_appropriate_message() 
	{
	   Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed());
	}

	@When("User does not enter the any product into the search bar")
	public void user_does_not_enter_the_any_product_into_the_search_bar() 
	{
	    
	}
}
