package Test.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class prop extends Base {
	public static Properties properties;
	
	
	//Reading properties file 
	
	public static String key(String param) {
		String value=null;
		properties=new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(".\\Test_Data\\cofiguration.properties");
			properties.load(file);
			value=properties.getProperty(param);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}