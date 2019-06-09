package guru99;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	/*public static void main(String[] args) {
		
		String homepage="http://www.zlti.com";
		String url=null;
		int respCode=200;
		HttpURLConnection huc=null; 
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        //goto the homepage
        driver.get(homepage);
        
        //collect all the links in the webpage
        List<WebElement> l1=driver.findElements(By.tagName("a"));
        //obtain the iterator to traverse through the list
        Iterator i1=l1.iterator();
        
        while(i1.hasNext()) {
        	//identifying and validating the URL
        	url=((WebElement) i1.next()).getAttribute("href");
        	System.out.println("URL:"+url);
        	
        	if (url==null||url.isEmpty()) {
        		System.out.println("URL is empty OR not configured for the a tag");
        		continue;
        	}
        	
        	if (!url.startsWith(homepage)) {
        		System.out.println("URL brlongs to other domain, so skipping it");
        		continue;
        	}
        	
        	try {
				huc= (HttpURLConnection) new URL(url).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				respCode=huc.getResponseCode();
				if(respCode>400) {
					System.out.println(url+"is a Broken link");
				}
				
				else {
					System.out.println(url+"is valid link ");
					
				}
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
		
		driver.quit();
	}*/
	
	public static void main(String[] args) {									
        String baseUrl = "http://demo.guru99.com/test/newtours/";					
        String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();					
        		
        String underConsTitle = "Under Construction: Mercury Tours";					
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);					

			driver.get(baseUrl);					
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
        String[] linkTexts = new String[linkElements.size()];							
			int i = 0;					

			//extract the link texts of each link element		
			for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();							
			i++;			
        }		

			//test each link		
			for (String t : linkTexts) {							
			driver.findElement(By.linkText(t)).click();					
			if (driver.getTitle().equals(underConsTitle)) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");			
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
			driver.navigate().back();			
        }		
			driver.quit();			
    }		
	
}
