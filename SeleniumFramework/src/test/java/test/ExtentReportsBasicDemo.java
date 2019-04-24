package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	public static void main(String[] args) {

		WebDriver driver=null;

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Bing Search", "This is a Sample Test");

		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();

		// log(Status, details)
		test.log(Status.INFO, "Starting test case");

		//goto google.com
		driver.get("https://bing.com/");
		test.pass("Navigated successfully");

		//enter text in search bar
		driver.findElement(By.id("sb_form_q")).sendKeys("Automation step by step");
		test.pass("Entered text in inbox");

		//click on search button                                                                                                                                                                       
		driver.findElement(By.id("sb_form_go")).click();
		test.pass("Clicked search");

		//close the browser
		driver.close();
		test.pass("Closed the browser");


		// info(details)
		test.info("Test is completed");


		// calling flush writes everything to the log file
		extent.flush();
	}



}
