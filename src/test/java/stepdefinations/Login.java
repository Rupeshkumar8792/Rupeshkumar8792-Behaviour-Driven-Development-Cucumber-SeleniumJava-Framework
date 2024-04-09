package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login 
{
	@Given("user should navigate to the login page")
	public void user_should_navigate_to_the_login_page() 
	{
	   
	}

	@When("user enters valid email address {string}")
	public void user_enters_valid_email_address(String string) 
	{
	   
	}

	@When("user enters valid password {string}")
	public void user_enters_valid_password(String string) 
	{
	    
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() 
	{
	    
	}

	@Then("user should able to log into the app successfully")
	public void user_should_able_to_log_into_the_app_successfully() 
	{
	    
	}

	@When("user enters invalid email address {string}")
	public void user_enters_invalid_email_address(String string) 
	{

	}

	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String string) 
	{

	}

	@Then("user should able to view appropriate error message")
	public void user_should_able_to_view_appropriate_error_message() 
	{

	}
}
