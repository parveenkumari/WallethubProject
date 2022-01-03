package parallel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.utility.listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
                 features = {"src/main/resources/parallel"},
                 glue = {"parallel"},
                // tags = "@UserAccount",
                 plugin = {"pretty",
                		   "json:target/cucumber.json"},
                 publish = true)

@Listeners(listeners.class)
public class runner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	
}
