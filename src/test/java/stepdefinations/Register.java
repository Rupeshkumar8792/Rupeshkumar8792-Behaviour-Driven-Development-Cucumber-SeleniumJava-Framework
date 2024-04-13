package stepdefinations;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
import utils.ConfigReader;

public class Register 
{
	DriverFactory gDriverFactory = new DriverFactory();
	WebDriver driver = gDriverFactory.getDriver();
	HomePage gHomePage = new HomePage(driver);
	RegisterPage gRegisterPage = new RegisterPage(driver);
	Properties prop;
	
	@Given("user should navigates to the registration page")
	public void user_should_navigates_to_the_registration_page() 
	{	
		gHomePage.clickOnMyAccount();
		gHomePage.clickOnRegister();	
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
		 Map<String, String> dataMap =  dataTable.asMap(String.class,String.class);
		 
		 gRegisterPage.enterFirstName(dataMap.get("firstName"));
		 gRegisterPage.enterLastName(dataMap.get("lastName"));
		 gRegisterPage.enterEmailID(new CommonUtils().getEmailwithTimestamps());
		 gRegisterPage.enterTelephoneNumber(dataMap.get("telephone"));
		 gRegisterPage.enterPassoword(dataMap.get("password"));
		 gRegisterPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@When("user checks in user policy")
	public void user_checks_in_user_policy() 
	{
		 gRegisterPage.clickOnPrivacyPolicyBTN();  
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
		 gRegisterPage.clickOnContinueBTN();	
	}

	@SuppressWarnings("deprecation")
	@Then("user should be able to view the successful registration message")
	public void user_should_be_able_to_view_the_successful_registration_message() 
	{
		AccountSuccessPage lAccountSuccessPage  = new AccountSuccessPage(driver);
	   Assert.assertEquals(lAccountSuccessPage.getSuccessMessage(), "Your Account Has Been Created!");
	   
	}

	@When("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		 gRegisterPage.clickOnYesSuscribeButton();
	}
	
	@When("user enters the details into duplicate detail below fields")
	public void user_enters_the_details_into_duplicate_detail_below_fields(DataTable dataTable) 
	{
 Map<String, String> dataMap =  dataTable.asMap(String.class,String.class);
		 
		 gRegisterPage.enterFirstName(dataMap.get("firstName"));
		 gRegisterPage.enterLastName(dataMap.get("lastName"));
		 gRegisterPage.enterEmailID(dataMap.get("email"));
		 gRegisterPage.enterTelephoneNumber(dataMap.get("telephone"));
		 gRegisterPage.enterPassoword(dataMap.get("password"));
		 gRegisterPage.enterConfirmPassword(dataMap.get("password"));
	}

	@Then("user should be able to view appropriate error message")
	public void user_should_be_able_to_view_appropriate_error_message() 
	{
		 Assert.assertEquals(gRegisterPage.failureMessage(), "Warning: E-Mail Address is already registered!");
	}
	
	@When("user dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() 
	{
		 gRegisterPage.clickOnContinueBTN();
	}

	@Then("user should get warning message for every mandatory fields")
	public void user_should_get_warning_message_for_every_mandatory_fields() 
	{	
		prop = ConfigReader.intializeProperties();
		Assert.assertTrue(gRegisterPage.firstNameErrorText().contains(prop.getProperty("firstNameErrorMessage")));
		Assert.assertTrue(gRegisterPage.lastNameErrorText().contains(prop.getProperty("lastNameErrorMessage")));
		Assert.assertTrue(gRegisterPage.emailErrorText().contains(prop.getProperty("emailErrorMessage")));
		Assert.assertTrue(gRegisterPage.telephoneErrorText().contains(prop.getProperty("telephoneErrorMessage")));
		Assert.assertTrue(gRegisterPage.passwordErrorText().contains(prop.getProperty("passwordErrorMessage")));
	}
}
