package Test.Automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementNotInteractableException;
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
public class tableTags extends Base{
	
	public static ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter(".\\HTML Report\\HTML_Table.html");
	public static ExtentTest test;
	
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
	
	@Test (priority=1)
	public void tableTag() throws Exception {
		test=extent.createTest("Click HTML Tables link");
		
		try {
		Base.ImpWait();
		driver.findElement(By.id(DataDriven.Excel(21, 0))).click();
		test.log(Status.PASS, "Link clicked");
		System.out.println("Testing HTML Web tables");
		}catch(Exception e) {
			takeScreenshot.screenShot("html table link");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\html table link.png");
		}
	}
	
	@Test(priority=2)
	public void tablesData() throws Exception{
		int col=0,row=0,i=0;
		test=extent.createTest("Write Table data in Spreadsheet (XLSX)");
		try {
			System.out.println("Writing table data into spreadsheet");
			
			 // Adding the table values into the list to write in the spreadsheet
		    
			File file1= new File(".\\Output\\HTMLTable_output.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sh = workbook.createSheet("OUTPUT");
			FileOutputStream file = new FileOutputStream(file1);
			List<WebElement> list1=driver.findElements(By.tagName("th"));
			List<WebElement> list2=driver.findElements(By.tagName("td"));
			List<WebElement> list3=ListUtils.union(list1,list2);
			for (i=0;i<list3.size()-1;i++) {
				sh.createRow(row).createCell(col).setCellValue(list3.get(i).getText());
				col++;i++;
				sh.getRow(row).createCell(col).setCellValue(list3.get(i).getText());
				row++;
				col=0;
			}
			 workbook.write(file);
			 workbook.close();
			 test.log(Status.PASS, "tableData");
			 System.out.println("Writing table data into Spreadsheet completed");
		} catch (Exception e) {
			System.out.println("Writing table data into Spreadsheet failed");
			takeScreenshot.screenShot("tableData");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\tableData.png");
		}
		
		//Navigate back to homepage
		
		driver.navigate().back();
	}
	
	@Test (priority=3)
	
	public static void dynamicTable() throws ElementNotInteractableException, Exception {
		System.out.println("Testing Dynamic HTML Web tables");
		test=extent.createTest("Dynamic Tables");
		driver.findElement(By.id(DataDriven.Excel(29, 0))).click();
		
		try {
			int col=0,row=0,i=0;
			driver.findElement(By.xpath("//*[text()='Table Data']")).click();
			Base.ImpWait();
			driver.findElement(By.id(DataDriven.Excel(30, 0))).sendKeys(DataDriven.Excel(31, 0));
			driver.findElement(By.id(DataDriven.Excel(32, 0))).click();
			
			//Writing data into the Spreadsheet XLSX
			
			File file1= new File(".\\Output\\HTML_DynamicTable_output.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sh = workbook.createSheet("OUTPUT");
			FileOutputStream file = new FileOutputStream(file1);
			List<WebElement> list1=driver.findElements(By.tagName("th"));
			List<WebElement> list2=driver.findElements(By.tagName("td"));
			List<WebElement> list3=ListUtils.union(list1,list2);
			
			for (i=0; i<list3.size()-1;i++) {
				sh.createRow(row).createCell(col).setCellValue(list3.get(i).getText());
				col++;i++;
				sh.getRow(row).createCell(col).setCellValue(list3.get(i).getText());
				row++;
				col=0;
			}
			 workbook.write(file);
			 workbook.close();
			 System.out.println("Writing Dynamic table data into Spreadsheet completed");
			test.log(Status.PASS, "Dynamic Table Test");
		}catch(Exception e) {
			System.out.println("Writing Dynamic table data into Spreadsheet failed");
			takeScreenshot.screenShot("DynamictableData");
			test.log(Status.FAIL, e).addScreenCaptureFromPath(".\\Screenshot\\DynamictableData.png");
		}
		
		driver.navigate().back();
	}
	
	//Closing the driver
	@AfterClass
	public void Close() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("The driver is closed");
		Base.close();
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
