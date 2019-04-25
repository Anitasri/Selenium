package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	static WebDriver driver=null;
	
	@BeforeTest
    public void setUpTest() {
    	
    	String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		 driver= new ChromeDriver();
		
    }

	@Test
	public static void googleSearch2()
	{
		
		//goto google.com
		driver.get("https://bing.com/");
		
		//enter text in search bar
		driver.findElement(By.id("sb_form_q")).sendKeys("Automation step by step");
		
		//click on search button                                                                                                                                                                       
		driver.findElement(By.id("sb_form_go")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void googleSearch3()
	{
		
		//goto google.com
		driver.get("https://bing.com/");
		
		//enter text in search bar
		driver.findElement(By.id("sb_form_q")).sendKeys("Automation step by step");
		
		//click on search button                                                                                                                                                                       
		driver.findElement(By.id("sb_form_go")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDownTest( ) {
		
		//close the browser
		driver.close();
				
		System.out.println("Test google search is completed");
	}

}
