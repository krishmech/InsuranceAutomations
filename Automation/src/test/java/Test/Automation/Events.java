package Test.Automation;

import java.io.IOException;
import Test.Automation.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@SuppressWarnings("unused")
public class Events extends Base {

	public static ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter(".\\HTML Report\\Event_Report.html");
	public ExtentTest test;

	/*
	 * @BeforeClass public void beforeClass() { test = extent.createTest("Driver");
	 * try { Base.Driver(); test.log(Status.PASS,
	 * "Driver Initialisation Successfull"); } catch (InterruptedException e) {
	 * test.log(Status.FAIL, e); } }
	 * 
	 * @Test public void URL_nav() { test = extent.createTest("URL"); try {
	 * Base.URL("URL"); test.log(Status.PASS, "URL Navigation Successfull"); } catch
	 * (Exception e) { test.log(Status.FAIL, e); } }
	 */

	@Test
	public void Event() throws Exception {
		test = extent.createTest("Event");
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(8, 0))).click();
			test.log(Status.PASS, "Events Click");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("Event click");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\Event click.png");
		}
	}

	@Test(priority = 1)
	public void Operation() throws Exception {
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(9, 0))).click();
			test.log(Status.PASS, "onBlur");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("blur");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\blur.png");
		}
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(10, 0))).click();
			driver.findElement(By.id(DataDriven.Excel(10, 0))).click();
			Thread.sleep(1000);
			test.log(Status.PASS, "onClick");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("click");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\click.png");
		}
		
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.contextClick(driver.findElement(By.id(DataDriven.Excel(11, 0)))).build().perform();
			test.log(Status.PASS, "contextClick");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("contextclick");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\contextclick.png");
		}
		
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.doubleClick((driver.findElement(By.id(DataDriven.Excel(12, 0))))).build().perform();
			test.log(Status.PASS, "doubleClick");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("doubleclick");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\doubleclick.png");
		}
		
		
		try {
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(13, 0))).click();
			test.log(Status.PASS, "onFocus");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("focus");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\focus.png");
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
			takeScreenshot.screenShot("keydown");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\keydown.png");
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
			takeScreenshot.screenShot("keyup");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\keyup.png");
		}
		
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(16, 0))).click();
			action.sendKeys(Keys.SPACE).build().perform();
			test.log(Status.PASS, "keyPress");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("keypress");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\keypress.png");
		}
		

		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.moveToElement(driver.findElement(By.id(DataDriven.Excel(17, 0)))).build().perform();
			test.log(Status.PASS, "onHover");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("onhover");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\onhover.png");
		}
		
		
		try {
			Actions action = new Actions(driver);
			Base.ImpWait();
			action.moveToElement(driver.findElement(By.id(DataDriven.Excel(18, 0)))).build().perform();
			test.log(Status.PASS, "onLeave");
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			takeScreenshot.screenShot("onleave");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\onleave.png");
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
			takeScreenshot.screenShot("mousedown");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\mousedown.png");
		}
		Base.ImpWait();

		// Navigate back to homepage
		driver.navigate().back();
		System.out.println("Events completed");
	}

	// Attaching the test to the HTML report
	@BeforeTest
	public void bt() {
		extent.attachReporter(spark);

	}

	// Attaching the test report to the HTML report
	@AfterTest
	public void af() {
		extent.flush();
	}

}
