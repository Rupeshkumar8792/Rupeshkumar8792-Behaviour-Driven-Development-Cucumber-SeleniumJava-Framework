package stepdefinations;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
		 driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailwithTimestamps());
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
	   String act = driver.findElement(By.xpath("//div[@id='content']//h1[text()='Your Account Has Been Created!']")).getText();
	   Assert.assertEquals(act, "Your Account Has Been Created!");
	}

	@When("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		driver.findElement(By.xpath("//input[@value=\"1\"][@name=\"newsletter\"]")).click();
	}
	
	private String getEmailwithTimestamps()
	{
		Date date = new Date();
		return "rupesh.surya"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
