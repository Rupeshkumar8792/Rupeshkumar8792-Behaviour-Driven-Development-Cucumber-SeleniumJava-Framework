package stepdefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Register 
{
	WebDriver driver = DriverFactory.getDriver();
	
	@Given("user should navigates to the registration page")
	public void user_should_navigates_to_the_registration_page() 
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
		 Map<String, String> dataMap =  dataTable.asMap(String.class,String.class);
		 driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("firstName"));
		 driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataMap.get("lastName"));
		 driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataMap.get("email"));
		 driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("telephone"));
		 driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("password"));
		 driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("password"));
	}

	@When("user checks in user policy")
	public void user_checks_in_user_policy() 
	{
	    driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("user should be able to view the successful registration message")
	public void user_should_be_able_to_view_the_successful_registration_message() 
	{
	   String act = driver.findElement(By.xpath("")).getText();
	   Assert.assertEquals(false, false);
	}

	@When("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		driver.findElement(By.xpath("//input[@value=\"1\"][@name=\"newsletter\"]")).click();
	}

	@Then("user should be able to view the appropriate error message")
	public void user_should_be_able_to_view_the_appropriate_error_message() 
	{
	    Assert.assertTrue(false);
	}

	@When("user does not enter any details")
	public void user_does_not_enter_any_details() 
	{
		Assert.assertTrue(driver.findElement(By.xpath("\"//div[text()='Warning: You must agree to the Privacy Policy!']\"")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-firstname\"]//following-sibling::div")).getText(), "First Name must be between 1 and 32 characters!");
	}
}
