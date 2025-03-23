package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import methods.LoginPage;
import org.openqa.selenium.WebDriver;
import utilities.DriverConfig;
import utilities.ScreenshotUtil;

public class ProfileLogin extends DriverConfig {

	WebDriver driver = DriverConfig.getDriver();
	
	@Given("User navigates to Naukri webpage")
        public void user_navigates_to_Naukri_webpage() {
            // Navigate to Google
            // Find the search bar using its name attribute and type "naukri"

           driver.get("https://www.naukri.com/");
           System.out.println("We are navigating to Naukri.com");
           String currentUrl = driver.getCurrentUrl();
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); 
           System.out.println("Current webpage URL: " + currentUrl);
	   ScreenshotUtil.takeScreenshot(driver, "naukri_homepage"); // Take screenshot of homepage
	   System.out.println("The screenshot is taken ");
	   WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8)); 
	   ScreenshotUtil.takeScreenshot(driver, "search_homepage");
 
		
        }


	@When("^the user login and enters valid (.*) and (.*)$")
	public void the_user_login_and_enters_valid_username_and_Automation(String username, String password) {
	        String pageTitle = driver.getTitle();
                System.out.println("Page Title: " + pageTitle);
	        ScreenshotUtil.takeScreenshot(driver, "naukri_title"); // Take screenshot of homepage

		LoginPage.LoginFunctionality(username, password);
	        ScreenshotUtil.takeScreenshot(driver, "naukri_login"); // Take screenshot of homepage
	        System.out.println("The screenshot is taken after log in");
	}

	@Then("the user should be logged in and he should be able to see his profile")
	public void the_user_should_be_logged_in_and_he_should_be_able_to_see_his_profile() throws InterruptedException {
	//	LoginPage.ProfileFunctionality();
	}

}
