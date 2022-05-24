package comInsuranceAutomation.InsuranceAutomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupFile {

	public static void SetupFiles() {
		System.setProperty("webdriver.chrome.driver",".\\src\\test\\repository\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}

}
