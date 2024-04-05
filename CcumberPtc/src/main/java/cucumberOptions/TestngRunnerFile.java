package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/main/java/features",glue = "stepDefinitions",dryRun = false,
plugin = {"pretty","html:target/cucumber.html","pretty,json:target/jsonFile.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})
public class TestngRunnerFile extends AbstractTestNGCucumberTests{

	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
