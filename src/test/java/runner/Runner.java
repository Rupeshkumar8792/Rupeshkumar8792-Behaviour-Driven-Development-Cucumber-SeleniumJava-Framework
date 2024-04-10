package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\rupeshkumar.suryawan\\eclipse-workspace\\BDDCucumberSeleniumJava\\src\\test\\resources\\features",
						glue = {"stepdefinations","hooks"})
public class Runner extends AbstractTestNGCucumberTests
{

}
