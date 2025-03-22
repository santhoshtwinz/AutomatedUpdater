package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {

		public static WebDriver driver;

	    public void setUp() {
	        driver = new ChromeDriver();

	    }
	
}
