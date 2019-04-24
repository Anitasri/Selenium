package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSearch();

	}

	public static void googleSearch()
	{
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com/");
		
		//enter text in search bar
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		
		//Since the search is hidden its not valid for the above step , adding to it use sendKeys(If it has more than one value of btnK its unable to trace)
//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//input[@value='Google Search']
	
		
		//own xpath for chrome non-clicking enter issue //Google search                                                                                                                                                                          
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		
		//close the browser
		driver.close();
		
		System.out.println("Test google search is completed");
	}
	
}
