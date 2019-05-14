package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsDemo {


	public static void main(String[] args) {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		//Use Chrome browser
		WebDriver driver = new ChromeDriver();

		// Initialize the eyes SDK and set your private API key.
		Eyes eyes = new Eyes();

		// Set the API key from the env variable. Please read the "Important Note"
		// section above.
		eyes.setApiKey("OtEXdtxY4fYkxBeS2bx4wrA4vM0VZ921bmmUBkuS107G8110");

		try {


			// Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
			eyes.open(driver, "HelloWorld!","My first selenium java test", new RectangleSize(800, 600));

			// Navigate the browser to the "ACME" demo app
			driver.get("https://applitools.com/helloworld?diff2");

			// Visual checkpoint #1.
			eyes.checkWindow("Hello");

			//Click the click me button
			driver.findElement(By.tagName("button")).click();

			//Visual checkpoint #2
			eyes.checkWindow("Click!");

			//🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟  
			//For example, you may want to test errors in the login window after clicking a login button,
			//In that case, you may add the following before you call eyes.close(). 
			//This will create a test with two test steps.
			//driver.click("login");
			//eyes.checkWindow("Login Window Error");

			// End the test.
			eyes.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as
			// aborted.
			eyes.abortIfNotClosed();

			// End main test
			System.exit(0);
		}

	}


}
