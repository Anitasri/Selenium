package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {

	public static final String USERNAME = "Anitasri";
	public static final String ACCESS_KEY = "35c7e2d9-b709-44f0-bcfc-caeab33cd524";
	public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String args[]) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();

		caps.setCapability("platform", "windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "Searchtest1");
		caps.setCapability("extendedDebugging", "true");
		
		//Saucelab test
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		//Normal test
		//String projectPath=System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		driver.get("https://bing.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("sb_form_q")).sendKeys("Auto");
		driver.findElement(By.id("sb_form_go")).click();
		System.out.println(driver.getTitle());
		
		driver.quit();
	    System.out.println("Completed");
	}

}