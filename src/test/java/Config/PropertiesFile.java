package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	
	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {

		GetProperties();
		SetProperties();
		GetProperties();
		
	}

	
	public static void GetProperties() throws IOException {
		
		
		
		
		
		InputStream input = new FileInputStream(projectPath + "/src/test/java/Config/Config.properties");
		
		prop.load(input);
		
		String browser = prop.getProperty("browser");
		
		System.out.println(browser);
	}
	
	public static void SetProperties() throws IOException {
		
		OutputStream output = new FileOutputStream(projectPath + "/src/test/java/Config/Config.properties");
		
		prop.setProperty("browser", "Chrome");
		
		prop.store(output, null);
	}
}
