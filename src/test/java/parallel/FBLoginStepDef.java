package parallel;

import com.base.BaseClass;
import com.pages.FBLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBLoginStepDef {
	
	FBLoginPage flp = new FBLoginPage();
	
	@Given("User navigate to facebook {string}")
	public void user_navigate_to_facebook(String url) {
	     flp.navigatetofacebook(url);
	}

	@When("User enter {string} and {string} on login page")
	public void user_enter_on_login_page(String username,String password) throws Exception {
	     flp.enterdata(username,password);
	}

	@When("User click on Log in button")
	public void user_click_on_log_in_button() throws Exception {
	     flp.clickonbutton();
	}

	@Then("User validate title of page")
	public void user_validate_title_of_page() {
	     flp.verifytitle();
	}

	@Then("User post status message {string}")
	public void user_post_status_message(String msg) throws Exception {
	     flp.postmsg(msg);
	}


}
