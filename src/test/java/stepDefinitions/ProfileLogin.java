package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;


import methods.LoginPage;
import org.openqa.selenium.WebDriver;
import utilities.DriverConfig;

public class ProfileLogin extends DriverConfig {

	WebDriver driver = DriverConfig.getDriver();
	
	@Given("User navigates to Naukri webpage")
        public void user_navigates_to_Naukri_webpage() {
           driver.get("https://www.naukri.com");
           System.out.println("We are navigating to Naukri.com");
           String currentUrl = driver.getCurrentUrl();
           System.out.println("Current webpage URL: " + currentUrl);
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
