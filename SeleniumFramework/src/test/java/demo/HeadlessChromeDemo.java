package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {

	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
	String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("window-size=1366,768");
	
	WebDriver driver= new ChromeDriver(options);
	
	driver.get("https://bing.com/");
	System.out.println(driver.getTitle());
	driver.findElement(By.id("sb_form_q")).sendKeys("Auto");
	driver.findElement(By.id("sb_form_go")).click();
	driver.close();
	System.out.println("Completed");
	}
}
