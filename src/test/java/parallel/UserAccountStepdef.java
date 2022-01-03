package parallel;

import java.io.IOException;

import com.pages.UserAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAccountStepdef {
	
	UserAccountPage uap = new UserAccountPage();

	@Given("enter url {string}")
	public void enter_url(String url) {
		uap.enter_url(url);
	     
	}
	@When("do few fucntions on review section")
	public void do_few_fucntions_on_review_section() {
	     uap.dofewfun();
	}
	
	@When("click policy dropdown and change the value to {string}")
	public void click_policy_dropdown_and_change_the_value_to(String text) {
	     uap.cliclpolicyandchangevalue(text);
	}
	@When("click on link and write some random text")
	public void click_on_link_and_write_some_random_text() {
	    uap.cliclonlinkandwriterandomtext();
	}
	@When("click on submit button")
	public void click_on_submit_button() {
		uap.clickonsubmit();
	    
	}
	@Then("verify confirmation screen")
	public void verify_confirmation_screen() throws InterruptedException, IOException {
		uap.verifyconfirmationscreen();
	}
	
	@Then("navigating to profile and asserting the review")
	public void navigating_to_url_and_asserting_the_review() {
		uap.navigatetourlandassert();
	     
	}


}
