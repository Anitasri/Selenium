package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_Demo;

public class PropertiesFile {

	static Properties prop =new Properties();
	static String projectLocation=System.getProperty("user.dir");
	
	public static void main(String[] args) {
  
		getProperties();
		setProperties();
		getProperties();
		
	}

	public static void getProperties() {

		try {
			
			InputStream input= new FileInputStream(projectLocation+"/src/test/java/config/config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String browser=prop.getProperty("browser");
			System.out.println(browser);
			TestNG_Demo.browserName=browser;
			
		} catch (FileNotFoundException e) {  
			e.printStackTrace();
		}

	}

	public static void setProperties() {
	
		try {
			OutputStream output= new FileOutputStream(projectLocation+"/src/test/java/config/config.properties");
			prop.setProperty("browser","chrome");
			try {
				prop.store(output, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
