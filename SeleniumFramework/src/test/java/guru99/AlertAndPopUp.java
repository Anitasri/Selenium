package guru99;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndPopUp {

	/*	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		// Alert Message handling

		driver.get("http://demo.guru99.com/test/delete_customer.php");			


		driver.findElement(By.name("cusid")).sendKeys("53920");					
		driver.findElement(By.name("submit")).submit();			

		// Switching to Alert        
		Alert alert = driver.switchTo().alert();		

		// Capturing alert message.    
		String alertMessage= driver.switchTo().alert().getText();		

		// Displaying alert message		
		System.out.println(alertMessage);	
		Thread.sleep(5000);

		// Accepting alert		
		alert.accept();		
	}*/	

	public static void main(String args[]) {

		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.linkText("Click Here")).click();

		//to handle the main window
		String mainWindow= driver.getWindowHandle();

		//to handle multiple windows
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();

		while(i1.hasNext())
		{
			String childWindow= i1.next();

			if(!mainWindow.equalsIgnoreCase(childWindow))
			{
				//switching to child window
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
				driver.findElement(By.name("btnLogin")).submit();
				//closing the child window
				driver.close();
			}
		}

		//switching back to the parent window
        driver.switchTo().window(mainWindow);

	}
}
