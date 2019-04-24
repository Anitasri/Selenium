import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	
	public static void main(String args[])
	{
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		
		//System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver",projectPath +"//drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver= new InternetExplorerDriver();
		
		//driver.get("https://mvnrepository.com/artifact/com.h2database/");
		driver.get("https://google.com/");
		List<WebElement> listOfWebElements=driver.findElements(By.xpath("//input"));
		int count=listOfWebElements.size();
		System.out.println("Count of web elements:"+count);
		
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		//driver.findElement(By.name("q")).sendKeys("abcd");
		//driver.quit();
		
		
	}

}
