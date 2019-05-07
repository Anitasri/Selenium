package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String args[]) {

		seleniumWaits();
	}
	public static void seleniumWaits() {

		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		
		System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("Auto");
		driver.findElement(By.id("sb_form_go")).click();
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("abcdefg")));
		
		driver.findElement(By.id("abcd")).click();
	}
}
