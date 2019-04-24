package test;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
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

	@BeforeSuite  //Run only once before all test cases
	public void setUp() {

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	public void test() {

		test = extent.createTest("Bing Search", "This is a Sample Test");

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

	@AfterSuite
	public void tearDown() {

		// calling flush writes everything to the log file
		extent.flush();

	}
}
