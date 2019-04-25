package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsWithTestNG {

	ExtentHtmlReporter htmlReporter=null;
	ExtentReports extent=null;
	ExtentTest test=null;

	WebDriver driver=null;

	@BeforeSuite  //Run only once before all test cases
	public void setUp() {

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extentReport.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);



	}

	@BeforeTest
	public void setUpTest() {

		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
	}



	@Test
	public void test() {

		test = extent.createTest("Bing Search", "This is a Sample Test");

		//goto google.com
		driver.get("https://bing.com/");
		test.pass("Navigated successfully");


		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// test with snapshot
		try {
			test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
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

	@AfterSuite
	public void tearDown() {

		// calling flush writes everything to the log file
		extent.flush();

	}
}
