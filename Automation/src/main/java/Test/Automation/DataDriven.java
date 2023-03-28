package Test.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class DataDriven extends Base {

	// Apache POI reading spreadsheet

	public static String Excel(int m, int n) throws IOException {
		FileInputStream file = new FileInputStream(".\\Test_Data\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(m);
		Cell cell = row.getCell(n);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		wb.close();
		return value;
	}

	// Apache POI writing spreadsheet
	
	public static void ExcelOutput(int m, int n, String value) throws IOException {

		FileInputStream file = new FileInputStream(".\\Output\\Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.createRow(m);
		Cell cell = row.createCell(n);
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(".\\Output\\Book1.xlsx");
		wb.write(out);
		out.close();
		wb.close();

	}

}
