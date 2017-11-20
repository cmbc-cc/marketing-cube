package marketingcube;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = 
//			{"pretty", "html:target/cucumberHtmlReport"},
//			{"html:target/cucumberHtmlReport"},     //  for html result
			{"json:target/cucumber-json-report.json"},  // for json result
		features = "classpath:features",
		glue = {
				"stepdefinition"  // predefined and user defined step definitions package
			   }
)

public class RunCukeTest { 	
}
