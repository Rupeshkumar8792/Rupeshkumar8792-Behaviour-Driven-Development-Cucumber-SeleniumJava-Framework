package stepdefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login 
{
	WebDriver driver = DriverFactory.getDriver();

	@Given("user should navigate to the login page")
	public void user_should_navigate_to_the_login_page() 
	{
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

	@When("user enters valid email address {string}")
	public void user_enters_valid_email_address(String emailText) 
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
	}

	@When("user enters valid password {string}")
	public void user_enters_valid_password(String password) 
	{
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() 
	{
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("user should able to log into the app successfully")
	public void user_should_able_to_log_into_the_app_successfully() 
	{
		//Assert.assertEquals(null, null);
	}

	@When("user enters invalid email address {string}")
	public void user_enters_invalid_email_address(String string) 
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(string);
	}

	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String string) 
	{
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(string);
	}

	@SuppressWarnings("deprecation")
	@Then("user should able to view appropriate error message")
	public void user_should_able_to_view_appropriate_error_message() 
	{
		//Assert.assertEquals(null, null);
	}

}
