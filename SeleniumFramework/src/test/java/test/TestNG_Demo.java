package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {

	static WebDriver driver=null;
	public static String browserName=null;

	@BeforeTest
	public void setUpTest() {

		String projectPath=System.getProperty("user.dir");
		PropertiesFile.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("ProjectPath:"+projectPath);
			System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("ProjectPath:"+projectPath);
			System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
		}
	}

	@Test
	public static void googleSearch()
	{

		//goto google.com
		driver.get("https://bing.com/");

		//enter text in search bar
		driver.findElement(By.id("sb_form_q")).sendKeys("Automation step by step");

		//click on search button                                                                                                                                                                       
		driver.findElement(By.id("sb_form_go")).click();


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDownTest( ) {

		//close the browser
		driver.close();

		System.out.println("Test google search is completed");
	}

}
