package methods;

import java.util.concurrent.TimeUnit;


import pageFactory.NaukriPageFactory;
import utilities.DriverConfig;

public class LoginPage extends DriverConfig {

	@SuppressWarnings("deprecation")
	public static void LoginFunctionality(String username, String password) {
		NaukriPageFactory pagefactory = new NaukriPageFactory();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pagefactory.Login_button.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pagefactory.userName.click();
		pagefactory.userName.sendKeys(username);
		pagefactory.password.click();
		pagefactory.password.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pagefactory.submitButton.click();

	}

	@SuppressWarnings("deprecation")
	public static void ProfileFunctionality() {
		NaukriPageFactory pagefactory = new NaukriPageFactory();

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String UserName = pagefactory.profileName.getText();
		System.out.println("1. The username is " + UserName);
		String UserWorkProfile = pagefactory.userWorkProfile.getText();
		System.out.println("2. The User profile is " + UserWorkProfile);
		String LastUpdatedOn = pagefactory.profileLastUpdated.getText();
		System.out.println("3. Was " + LastUpdatedOn);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		pagefactory.hamBurger.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		pagefactory.logOutButton.click();
	}
}
