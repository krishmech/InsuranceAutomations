package Test.Automation;

import Test.Automation.DataDriven;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

@SuppressWarnings("unused")
public class Alert_DAD  extends Base{

	public static ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter(".\\HTML Report\\Alert_DragAndDrop.html");
	public ExtentTest test;
	
	//Browser initialisation
	@BeforeClass
	public void beforeClass() {
		test = extent.createTest("Driver");
		try {
			Base.Driver();
			test.log(Status.PASS, "Driver Initialisation Successfull");
			System.out.println("Browser Initialised");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, e);
			System.out.println("Browser initialisation failed");
		}
	}
	
	//URL Navigation
	
	@Test
	public void URL_nav() throws Exception {
		test = extent.createTest("URL");
		try {
			Base.URL("URL");
			test.log(Status.PASS, "URL Navigation Successfull");
			System.out.println("URL navigation succesfull");
		} catch (Exception e) {
			takeScreenshot.screenShot("URL nav");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\URL nav.png");
			System.out.println("URL navigation successfull");
		}
	}

	//Drag and drop operation
	
	@Test(priority = 1)
	public void DragAndDrop() throws Exception {
		test = extent.createTest("Drag and Drop");
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(0, 0))).click();
			Base.ImpWait();
			
			// Using Actions class for drag and drop
			
			Actions action = new Actions(driver);
			action.dragAndDrop((driver.findElement(By.id(DataDriven.Excel(1, 0)))),
					(driver.findElement(By.id(DataDriven.Excel(1, 1))))).build().perform();
			action.dragAndDrop((driver.findElement(By.id(DataDriven.Excel(2, 0)))),
					(driver.findElement(By.id(DataDriven.Excel(2, 1))))).build().perform();
			test.log(Status.PASS, "Drag And Drop Completed");
			Base.ImpWait();
			
			//Navigate back to homepage
			
			driver.navigate().back();
			System.out.println("Drag and drop completed");
		} catch (Exception e) {
			System.out.println("Drag and drop failed");
			takeScreenshot.screenShot("Drag and Drop");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Drag and Drop.png");
		}
	}

	//Working with the Alert
	
	@Test(priority = 2)
	public void Alert() throws Exception {
		
		test = extent.createTest("Alert");
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(3, 0))).click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("Alert link");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Alert link.png");
		}
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(4, 0))).click();
			driver.switchTo().alert().accept();
			test.log(Status.PASS, "Accept");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("Accept alert");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Accept alert.png");
		}
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(5, 0))).click();
			driver.switchTo().alert().dismiss();
			test.log(Status.PASS, "Dismiss");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("Dismiss alert");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Dismiss alert.png");
		}
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(6, 0))).click();
			Base.ImpWait();
			driver.switchTo().alert().accept();
			test.log(Status.PASS, "Send Text");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("Alert Send Keys");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Alert Send Keys.png");
		}
		
		//Navigate back to homepage
		driver.navigate().back();
		System.out.println("Alert completed");
	}
	
	
	
	@Test(priority=3)
	public void fakeEvents() throws Exception {
	test=extent.createTest("Fake Alerts");
	try {
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(22, 0))).click();
		test.log(Status.PASS, "Fake alert link");
	}catch(Exception e) {
		takeScreenshot.screenShot("fakeEvent link");
		test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\fakeEvent Link.png");
	}
	
	
	try {
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(23, 0))).click();
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(24, 0))).click();
		test.log(Status.PASS, "Fake alert link");
	}catch(Exception e) {
		takeScreenshot.screenShot("Fake alert link");
		test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Fake alert link.png");
	}
	
	
	try {
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(25, 0))).click();
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(26, 0))).click();
		test.log(Status.PASS, "Fake modalalert link");
	}catch(Exception e) {
		takeScreenshot.screenShot("Fake modalalert");
		test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Fake modalalert.png");
	}
	
	
	Base.ImpWait();
	
	//Navigate back to homepage
	driver.navigate().back();
	System.out.println("Fake Events completed");
}
	
/*	@Test(priority=3)
	public void Events() throws InterruptedException {
		test = extent.createTest("Event");
		try {
			driver.findElement(By.id(DataDriven.Excel(8, 0))).click();
			Base.ImpWait();
			test.log(Status.PASS, "Events Click");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			driver.findElement(By.id(DataDriven.Excel(9, 0))).click();
			Base.ImpWait();
			test.log(Status.PASS, "onBlur");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			driver.findElement(By.id(DataDriven.Excel(10, 0))).click();
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(10, 0))).click();
			Thread.sleep(1000);
			test.log(Status.PASS, "onClick");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.contextClick(driver.findElement(By.id(DataDriven.Excel(11, 0)))).build().perform();
			test.log(Status.PASS, "contextClick");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.doubleClick((driver.findElement(By.id(DataDriven.Excel(12, 0))))).build().perform();
			test.log(Status.PASS, "doubleClick");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(13, 0))).click();
			test.log(Status.PASS, "onFocus");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(14, 0))).click();
			action.keyDown(Keys.ARROW_DOWN).build().perform();
			test.log(Status.PASS, "keyDown");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(15, 0))).click();
			action.keyUp(Keys.ARROW_DOWN).build().perform();
			test.log(Status.PASS, "keyUp");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(16, 0))).sendKeys(Keys.PAGE_DOWN);
			test.log(Status.PASS, "keyPress");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.moveToElement(driver.findElement(By.id(DataDriven.Excel(17, 0)))).build().perform();
			test.log(Status.PASS, "onHover");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.moveToElement(driver.findElement(By.id(DataDriven.Excel(18, 0)))).build().perform();
			test.log(Status.PASS, "onLeave");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.clickAndHold(driver.findElement(By.id(DataDriven.Excel(19, 0)))).build().perform();
			action.release(driver.findElement(By.id(DataDriven.Excel(19, 0)))).build().perform();
			test.log(Status.PASS, "onMouseDown");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e);
		}
		Base.ImpWait();
		driver.navigate().back();
		
	}

	@AfterClass
	public void Close() {
		Base.close();
	*/
	
	//Attaching the test to the HTML report
	@BeforeTest
	public void bt() {
		extent.attachReporter(spark);

	}
	
	//Attaching the test report to the HTML report
	@AfterTest
	public void af() {
		extent.flush();
	}

}
