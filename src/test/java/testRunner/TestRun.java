package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features"},
		glue="stepdefinations",
				plugin= {"pretty", "html:reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
				dryRun=false,
				monochrome=true,
				publish=true,
		tags="@smoke or @regression"
		)
public class TestRun {

}
