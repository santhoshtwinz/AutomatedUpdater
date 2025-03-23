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
           driver.get("https://www.google.com");

            // Find the search bar using its name attribute and type "naukri"
           WebElement searchBox = driver.findElement(By.name("q"));
           searchBox.sendKeys("naukri");
           searchBox.sendKeys(Keys.ENTER);   // Equivalent, works the same
	    // Press the Enter key to start the search
           System.out.println("searching for naukri");
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));  // Wait for up to 8 seconds
	   ScreenshotUtil.takeScreenshot(driver, "search_homepage"); // Take screenshot of homepage
            // Wait for the results to load and click on the first search result link
	//   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'Naukri.com: Jobs')]")));  // Wait until the element is visible

    //        WebElement firstLink = driver.findElement(By.xpath("//h3[contains(text(), 'Naukri.com: Jobs')]"));
    //        firstLink.click();  // Click on the first result
    //        String currentUrl = driver.getCurrentUrl();
    //        System.out.println("Current webpage URL: " + currentUrl);
	   // ScreenshotUtil.takeScreenshot(driver, "naukri_homepage"); // Take screenshot of homepage
	   // System.out.println("The screenshot is taken ");
	   // String pageSource = driver.getPageSource();
    //        System.out.println("The page source is "+pageSource);
 
		
        }


	@When("^the user login and enters valid (.*) and (.*)$")
	public void the_user_login_and_enters_valid_username_and_Automation(String username, String password) {
	        String pageTitle = driver.getTitle();
                System.out.println("Page Title: " + pageTitle);
	        ScreenshotUtil.takeScreenshot(driver, "naukri_title"); // Take screenshot of homepage

		LoginPage.LoginFunctionality(username, password);
	}

	@Then("the user should be logged in and he should be able to see his profile")
	public void the_user_should_be_logged_in_and_he_should_be_able_to_see_his_profile() throws InterruptedException {
		LoginPage.ProfileFunctionality();
	}

}
