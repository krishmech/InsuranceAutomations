package Test.Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base

{
	public static WebDriver driver;

	
	//Wbedriver initialisation
	
	public static void Driver() throws InterruptedException {
		try {
			if (prop.key("Browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (prop.key("Edge").equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", ".\\Drivers\\chromedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//URL Navigation
	public static void URL(String link) {
		driver.get(prop.key(link));
	}
	
	//Implicit wait
	public static void ImpWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//Quitting the Webdriver
	public static void close() {
		driver.quit();
	}
}