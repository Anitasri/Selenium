package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitDemo {

	@Test
	public void test() throws Exception {
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		
		System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("Abcd");
		driver.findElement(By.id("sb_form_go")).click();
		//driver.findElement(By.linkText("ABCD - Wikipedia")).click();
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30,TimeUnit. SECONDS)
		       .pollingEvery(2,TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement= driver.findElement(By.linkText("ABCD - Wikipedia"));
		    
		       if(linkElement.isEnabled()) {
		    	   System.out.println("Element found" );
		       }
		    	   return linkElement; 
		     
		     }
		   });

		   element.click(); //link click
		
		Thread.sleep(3000);
		
		driver.close();
	}
	
}
