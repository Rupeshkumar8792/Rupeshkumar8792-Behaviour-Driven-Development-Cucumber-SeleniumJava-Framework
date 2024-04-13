package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\rupeshkumar.suryawan\\eclipse-workspace\\BDDCucumberSeleniumJava\\src\\test\\resources\\features",
						glue = {"stepdefinations","hooks"},publish = true,
						plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}
