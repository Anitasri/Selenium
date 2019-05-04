package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;



//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	WebDriver driver=null;
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://bing.com/");
		driver.findElement(By.name("q")).sendKeys("Auto");
        driver.quit();		
		
	
	}
	
	@Test
	public void test3() {
		System.out.println("Test3");
		throw new SkipException("Skipped");
	}

}
