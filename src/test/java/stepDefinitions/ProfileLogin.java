package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import methods.LoginPage;
import utilities.DriverConfig;

public class ProfileLogin extends DriverConfig {

	@Before  // Cucumber hook to run before each scenario
        public void setUpBefore() {
          setUp();
        }
	
	@Given("User navigates to Naukri webpage")
        public void user_navigates_to_Naukri_webpage() {
        if (driver == null) {
           throw new RuntimeException("WebDriver not initialized");
        }
           driver.get("https://www.naukri.com");
        }


	@When("^the user login and enters valid (.*) and (.*)$")
	public void the_user_login_and_enters_valid_username_and_Automation(String username, String password) {

		LoginPage.LoginFunctionality(username, password);

	}

	@Then("the user should be logged in and he should be able to see his profile")
	public void the_user_should_be_logged_in_and_he_should_be_able_to_see_his_profile() throws InterruptedException {
		
		LoginPage.ProfileFunctionality();

	}

}
