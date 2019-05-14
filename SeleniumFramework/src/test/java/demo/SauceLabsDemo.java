package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SauceLabsDemo  {


	WebDriver driver= null;

	@Test
	public void test() throws Exception {

		/**
		 * In this section, we will configure our SauceLabs credentials in order to run our tests on saucelabs.com
		 */
		String sauceUserName = "Anitasri";
		String sauceAccessKey = "35c7e2d9-b709-44f0-bcfc-caeab33cd524";

		/**
		 * In this section, we will configure our test to run a specific
		 * browser/os combination in Sauce Labs
		 */

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("username", sauceUserName);

		//set your sauce labs access key
		caps.setCapability("accessKey", sauceAccessKey);

		//set browser to chrome
		caps.setCapability("browserName", "chrome");

		caps.setCapability("platform", "linux");
		//caps.setCapability("platform", "windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest1");
		caps.setCapability("buildNumber", "3.0");

		caps.setCapability("name", "Searchtest1");// to name the test,By default: its unamed test
		caps.setCapability("extendedDebugging","true"); //for network logs

		/**
		 * In this section, we will set the WebDriver to a Remote driver to run on sauce, and pass the capabilities
		 * we just set. Then we perform some actions on the page before quitting the driver.
		 */

		//create a new Remote driver that will allow your test to send
		// commands to the Sauce Labs grid so that Sauce can execute your tests
		/** If you're accessing the EU data center, use the following endpoint:.
		 * https://ondemand.eu-central-1.saucelabs.com/wd/hub
		 * */

		driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), caps);

		//Normal test
		/*String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();*/

		driver.get("https://bing.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("sb_form_q")).sendKeys("Auto");
		driver.findElement(By.id("sb_form_go")).click();
		System.out.println(driver.getTitle());

		driver.quit();
		System.out.println("Completed");
	}
}