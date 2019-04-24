package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	static WebDriver driver=null;
	
	public static void main(String[] args) {
		googleSearch();

	}

	public static void googleSearch()
	{
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
	   driver= new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com/");
		
		//enter text in search bar
		//driver.findElement(By.name("q")).sendKeys("Automation step by step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();                                                                                                                                                                       
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		//close the browser
		driver.close();
		
		System.out.println("Test google search is completed");
	}

}
