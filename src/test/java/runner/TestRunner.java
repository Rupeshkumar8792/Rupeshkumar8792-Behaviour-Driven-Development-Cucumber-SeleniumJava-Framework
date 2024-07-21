package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Rupesh\\git\\Rupeshkumar8792-Behaviour-Driven-Development-Cucumber-SeleniumJava-Framework\\src\\test\\resources\\features",
						glue = {"stepdefinations","hooks"},publish = true,
						plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}
