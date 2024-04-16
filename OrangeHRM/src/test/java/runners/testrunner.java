package runners;
import org.testng.annotations.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
		dryRun = false, 
		glue = { "test.stepDefinition" },
		features = {"C://Users/KSPL/IdeaProjects/OrangeHRM/src/test/resources/Feature"},
		tags= "@LoginPage",
//		plugin = {"json:target/cucumber.json"})
//		plugin = {
//				"json:target/cucumber-reports/cucumber-html-report.json", 
//				"usage:target/cucumber-reports/cucumber-usage.json",
//				"rerun:target/cucumber-reports/failedscenarios.txt" })

		plugin = {"pretty","html:target/htmlreport.html",
				/*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/})
		
//		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class testrunner extends AbstractTestNGCucumberTests {
	
}
