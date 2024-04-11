package stepdefinations;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtils;
import utils.ConfigReader;

public class Login 
{
	WebDriver driver = DriverFactory.getDriver();
	HomePage gHomePage;
	LoginPage gLoginPage;
	MyAccountPage gMyAccountPage;
	
	Properties prop = ConfigReader.intializeProperties();
	
	@Given("user should navigate to the login page")
	public void user_should_navigate_to_the_login_page() 
	{
		gHomePage = new HomePage(driver);
		gHomePage.clickOnMyAccount();
		gHomePage.clickOnLogin();
	}

	@When("user enters valid email address {string}")
	public void user_enters_valid_email_address(String emailText) 
	{
		gLoginPage = new LoginPage(driver);
		gLoginPage.enterEmailId(emailText);
	}

	@When("user enters valid password {string}")
	public void user_enters_valid_password(String password) 
	{
		gLoginPage = new LoginPage(driver);
		gLoginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() 
	{
		gLoginPage = new LoginPage(driver);
		gLoginPage.clickOnLoginButton();
	}

	@SuppressWarnings("deprecation")
	@Then("user should able to log into the app successfully")
	public void user_should_able_to_log_into_the_app_successfully() 
	{
		gMyAccountPage = new MyAccountPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(gMyAccountPage.editYourAccountInformationText());
		
	}

	@When("user enters invalid email address {string}")
	public void user_enters_invalid_email_address(String invalidEmail) 
	{
		gLoginPage = new LoginPage(driver);
		gLoginPage.enterEmailId(CommonUtils.getEmailwithTimestamps());
	}

	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPassword) 
	{
		gLoginPage = new LoginPage(driver);
		gLoginPage.enterPassword(invalidPassword);
	}

	@Then("user should able to view appropriate error message")
	public void user_should_able_to_view_appropriate_error_message() 
	{	
		gLoginPage = new LoginPage(driver);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(gLoginPage.getErrorText());
	}
	
}
