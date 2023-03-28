package Test.Automation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@SuppressWarnings("unused")
public class Frames extends Base{
	
	public static ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter(".\\HTML Report\\Frames.html");
	public ExtentTest test;
	
	public static List<WebElement> frames_list;
	public static List<WebElement> list;
	public static XSSFWorkbook wb;
	
	/*@BeforeClass
	public void beforeClass() {
		test = extent.createTest("Driver");
		try {
			Base.Driver();
			test.log(Status.PASS, "Driver Initialisation Successfull");
		} catch (InterruptedException e) {
			test.log(Status.FAIL, e);
		}
	}

	@Test
	public void URL_nav() {
		test = extent.createTest("URL");
		try {
			Base.URL("URL");
			test.log(Status.PASS, "URL Navigation Successfull");
		} catch (Exception e) {
			test.log(Status.FAIL, e);
		}
	}*/
	
  @Test(priority=1)
  public void iframes() throws Exception{
	  test = extent.createTest("Frames");
	  
	  Base.ImpWait();
	  
	  try {
		  System.out.println("Testing iFrames");
		  int j=0,i=0;
		  driver.findElement(By.id(DataDriven.Excel(20, 0))).click();
		  Base.ImpWait();
		  System.out.println("Writing data into Spreadsheet");
		  
		  
		  // Adding the frames ID into the list to navigate through the frames
		  
		  frames_list=driver.findElements(By.id(DataDriven.Excel(27, 0)));
		  test.log(Status.PASS, "Frames added to the list");
		    File file1= new File(".\\Output\\iFrames_output.xlsx");
			FileOutputStream file = new FileOutputStream(file1);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sh = workbook.createSheet("OUTPUT");
		  
		  for(WebElement element : frames_list) {
				  driver.switchTo().frame(element);
				  list=driver.findElements(By.tagName("li"));
				  for(WebElement value : list) {
				  sh.createRow(i).createCell(0).setCellValue(value.getText());
				  i++;
				  }
				 j++;

		  }
		  
			 workbook.write(file);
			 workbook.close();
			 driver.switchTo().parentFrame();
			 Base.ImpWait();
			 
			//Navigate back to homepage
			 driver.navigate().back();
			 System.out.println("writing data completed");
			 System.out.println("iFrames completed");
		  test.log(Status.PASS, "iFrames Test Page : Write values in Spreadsheet (XLSX)");
	  }catch(Exception e) {
		  System.out.println("iFrames failed");
		  takeScreenshot.screenShot("iFrames test");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\iFrames test.png");
	  }
  }
	
	@Test(priority=2)
	public void frames2() throws Exception {
		
		
		try {
			System.out.println("Testing frames");
		int i,row=0;
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(28, 0))).click();
		File file1= new File(".\\Output\\Frames_output.xlsx");
		FileOutputStream file = new FileOutputStream(file1);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sh = workbook.createSheet("OUTPUT");
		for (i=1;i<=3;i++) {
		driver.switchTo().frame(i);
		
		 // Adding the frames ID into the list to navigate through the frames
		
		System.out.println("Switching to frame :"+i);
		List<WebElement> list=driver.findElements(By.tagName("li"));
		List<WebElement> heading=driver.findElements(By.tagName("h1"));
		sh.createRow(row).createCell(0).setCellValue(heading.get(0).getText());
		System.out.println("Writing frame "+i+" into the Spreadsheet");
		for(WebElement element : list) {
			sh.createRow(row).createCell(0).setCellValue(element.getText());
			row++;
		}
		row++;
		list.clear();
		heading.clear();
		driver.switchTo().parentFrame();
		}
		workbook.write(file);
		workbook.close();
		Base.ImpWait();
		
		//Navigate back to homepage
		driver.navigate().back();
		System.out.println("Frames completed");
		test.log(Status.PASS, "Frames Test Page : Write values in Spreadsheet (XLSX)");
	}
	catch(Exception e) {
		 System.out.println("Testing frames failed");
		 takeScreenshot.screenShot("Frames test");
		 test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\iFrames test.png");
	}
	}
	
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
