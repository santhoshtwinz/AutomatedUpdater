package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverConfig;

public class NaukriPageFactory extends DriverConfig{

	@FindBy(xpath = "//a[@title='Jobseeker Login']")
	public WebElement Login_button;
	
	@FindBy(xpath = "//*[contains(@placeholder, 'Username')]")
	public WebElement userName;

	@FindBy(xpath = "//*[contains(@placeholder, 'password')]")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//*[@class='info__heading']")
	public WebElement profileName;
	
	@FindBy(xpath = "//*[@class='info__sub-heading']")
	public WebElement userWorkProfile;
	
	@FindBy(xpath = "//*[@class='info__sub-heading']/following::p")
	public WebElement profileLastUpdated;

	@FindBy(xpath = "//div[contains(@class, 'drawer')]")
	public WebElement hamBurger;
	
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logOutButton;
	
	

	public NaukriPageFactory() {
		PageFactory.initElements(driver, this);
	}
}
