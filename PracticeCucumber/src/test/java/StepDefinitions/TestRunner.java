package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Hooks.feature",glue={"StepDefinitionsForHooks"},
monochrome = true,
plugin = {"pretty","html:target/HTMLReportS",
 "json:target/JSONReports/report.json",
 "junit:target/JunitReports/report.xml"}
//tags = {"@smoke snd @regression"}
)
public class TestRunner {

	
}
