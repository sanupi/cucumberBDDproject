package testRunner;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)//using for cucumber junit
@CucumberOptions
(
		//particular one file executing
		//features = ".//Features/customers.feature",
		//all executing features file
		//features = ".//Features/",
		features = {".//Features/Loginpage.feature",".//Features/customers.feature"},
		
		glue="stepdefination",
		dryRun = false ,
		monochrome = true,
		//single reports to give
		tags="@sanity",
		//cucumber reports generate
	//plugin={"pretty","html:target/cucumber-reports/reports_html.html"}
	//	plugin={"pretty","json:target/cucumber-reports/reports_json.json"}
	//	plugin={"pretty","junit:target/cucumber-reports/reports_xml.xml"}
		
		//generate extend reports plugin
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		
		
		
		//multiple reports give
		
			//	plugin={"pretty","html:target/cucumber-reports/reports_html.html","json:target/cucumber-reports/reports_json.json","junit:target/cucumber-reports/reports_xml.xml"}
		)
		
		
		


public class Run extends AbstractTestNGCucumberTests {
//empty class
}
