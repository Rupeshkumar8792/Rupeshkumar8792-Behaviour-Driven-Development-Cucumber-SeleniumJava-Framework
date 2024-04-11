package stepdefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register 
{
	WebDriver driver = DriverFactory.getDriver();
	HomePage gHomePage;
	RegisterPage gRegisterPage;
	
	@Given("user should navigates to the registration page")
	public void user_should_navigates_to_the_registration_page() 
	{
		gHomePage = new HomePage(driver);
		gHomePage.clickOnMyAccount();
		gHomePage.clickOnRegister();
		
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
		 Map<String, String> dataMap =  dataTable.asMap(String.class,String.class);
		 
		 gRegisterPage = new RegisterPage(driver);
		 gRegisterPage.enterFirstName(dataMap.get("firstName"));
		 gRegisterPage.enterLastName(dataMap.get("lastName"));
		 gRegisterPage.enterEmailID(CommonUtils.getEmailwithTimestamps());
		 gRegisterPage.enterTelephoneNumber(dataMap.get("telephone"));
		 gRegisterPage.enterPassoword(dataMap.get("password"));
		 gRegisterPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@When("user checks in user policy")
	public void user_checks_in_user_policy() 
	{
		 gRegisterPage = new RegisterPage(driver);
		 gRegisterPage.clickOnPrivacyPolicyBTN();
	  
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
		 gRegisterPage = new RegisterPage(driver);
		 gRegisterPage.clickOnContinueBTN();
		
	}

	@SuppressWarnings("deprecation")
	@Then("user should be able to view the successful registration message")
	public void user_should_be_able_to_view_the_successful_registration_message() 
	{
		gRegisterPage = new RegisterPage(driver);
		
	   String actual = gRegisterPage.getSuccessMessage();
	   Assert.assertEquals(actual, "Your Account Has Been Created!");
	   
	}

	@When("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		 gRegisterPage = new RegisterPage(driver);
		 gRegisterPage.clickOnYesSuscribeButton();
	}
	
}
