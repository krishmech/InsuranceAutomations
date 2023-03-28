package Test.Automation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class takeScreenshot extends Base {
	
	//TakesSchreenshot interface to capture the failure with added argument as a filename

	public static void screenShot(String filename) throws Exception {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".\\Screenshot\\" + filename + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
}