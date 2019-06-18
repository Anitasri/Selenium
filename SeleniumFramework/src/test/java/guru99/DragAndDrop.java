package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	WebDriver driver;			

	@Test		
	public void DragnDrop()					
	{		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/drag_drop.html");					

		/* //Element which needs to drag.    		
		WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	

		//Element on which need to drop.		
		WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					

		//Using Action class for drag and drop.		
		Actions act=new Actions(driver);					

		//1.BANK element is dragged and dropped on the specific cell by DragAndDrop method.		
		//act.dragAndDrop(From, To).build().perform();	
		
		//2.BANK element is dragged and dropped on the specific cell by DragAndDrop method.
	    //act.dragAndDropBy(From,135, 40).build().perform(); */		
			
	   
	    //3.Few elements are dragged and dropped and then verify the message is displayed or not.
	    					
	     
		//Element(BANK) which need to drag.		
	     	 WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
	         
	     	//Element(DEBIT SIDE) on which need to drop.		
	     	WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));					
	      
		//Element(SALES) which need to drag.		
	     	WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
	        
		//Element(CREDIT SIDE) on which need to drop.  		
	     	WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));					
	     
	     	//Element(500) which need to drag.		
	        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
	        
	        //Element(DEBIT SIDE) on which need to drop.		
	     	WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));					
	         
		//Element(500) which need to drag.		
	        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
	        
	        //Element(CREDIT SIDE) on which need to drop.		
	     	WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));					
	      
		//Using Action class for drag and drop.		
	     	Actions act=new Actions(driver);					

		//BANK drag and drop.		
	     	act.dragAndDrop(From1, To1).build().perform();
	        
		//SALES drag and drop.		
	     	act.dragAndDrop(From2, To2).build().perform();
	        
		//500 drag and drop debit side.		
	     	act.dragAndDrop(From3, To3).build().perform();	
	        
		//500 drag and drop credit side. 		
	     	act.dragAndDrop(From4, To4).build().perform();		
	      
		//Verifying the Perfect! message.		
		if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())							
	     	{		
	         	System.out.println("Perfect Displayed !!!");					
	     	}
			else
	     	{
	        	System.out.println("Perfect not Displayed !!!");					
	     	}		
		
	}		

}
