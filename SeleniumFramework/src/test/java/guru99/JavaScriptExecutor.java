package guru99;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

	/*
	@Test		
    public void Login() 					
    {		

		//Launch the browser.
		//Open site "http://demo.guru99.com/V4/ ".
		//Application waits for 5 sec to perform a further action.
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();			

        //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
        		
        //Launching the Site.		
        driver.get("http://demo.guru99.com/V4/");			
     
          //Maximize window		
          driver.manage().window().maximize();		
        		
          //Set the Script Timeout to 20 seconds		
          driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);			
             
          //Declare and set the start time		
          long start_time = System.currentTimeMillis();			
                   
          //Call executeAsyncScript() method to wait for 5 seconds		
          js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
          		
         //Get the difference (currentTime - startTime)  of times.		
         System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));					
                    		
    } */

	    /*@Test		
	    public void Login() 					
	    {		
	    	
	    	Example of executeScript
	    	For executeScript, we will see three different example one by one.

	    	1) Example: Click a button to login and generate Alert window using JavaScriptExecutor.
	    	In this scenario, we will use "Guru99" demo site to illustrate JavaScriptExecutor. In this example,

	    	Launch the web browser
h	    	open the site "http://demo.guru99.com/V4/ "and
	    	login with credentials
	    	Execute JavaScript based code using Selenium Webdriver
	    	Display alert window on successful login.
	    	
	    	
	    	String projectPath=System.getProperty("user.dir");
			System.out.println("ProjectPath:"+projectPath);
			System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
	        
	        WebDriver driver = new ChromeDriver();		
	        		
	        //Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js = (JavascriptExecutor)driver;		
	        		
	        //Launching the Site.		
	        driver.get("http://demo.guru99.com/V4/");			
	        		
	        WebElement button =driver.findElement(By.name("btnLogin"));			
	        		
	        //Login to Guru99 		
	        driver.findElement(By.name("uid")).sendKeys("mngr34926");					
	        driver.findElement(By.name("password")).sendKeys("amUpenu");					
	        		
	        //Perform Click on LOGIN button using JavascriptExecutor		
	        js.executeScript("arguments[0].click();", button);
	                                
	        //To generate Alert window using JavascriptExecutor. Display the alert message 			
	        js.executeScript("alert('Welcome to Guru99');");   
	    		
	    }	*/
	

	    /*@Test		
	    public void Login() 					
	    {		
	    	
	    	2) Example: 
	    		Launch the site
	    		Fetch the details of the site like URL of the site, title name and domain name of the site.
	    		Then navigate to a different page.
	    	
	    	String projectPath=System.getProperty("user.dir");
			System.out.println("ProjectPath:"+projectPath);
			System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
	        
	        WebDriver driver = new ChromeDriver();			
	        		
	        //Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js = (JavascriptExecutor)driver;		
	        		
	        //Launching the Site.		
	        driver.get("http://demo.guru99.com/V4/");
				
	        //Fetching the Domain Name of the site. Tostring() change object to name.		
	        String DomainName = js.executeScript("return document.domain;").toString();			
	        System.out.println("Domain name of the site = "+DomainName);					
	          		
	        //Fetching the URL of the site. Tostring() change object to name		
	        String url = js.executeScript("return document.URL;").toString();			
	        System.out.println("URL of the site = "+url);					
	          		
	       //Method document.title fetch the Title name of the site. Tostring() change object to name		
	       String TitleName = js.executeScript("return document.title;").toString();			
	       System.out.println("Title of the page = "+TitleName);					

	        		
	      //Navigate to new Page i.e to generate access page. (launch new url)		
	      js.executeScript("window.location = 'http://demo.guru99.com/'");			
	    }*/		

	@Test		
    public void Login() 					
    {		
		
		//3) Example:	Launch the site & Scroll down by 600 pixel
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();			
        		
        //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
        		
        //Launching the Site.		
        driver.get("http://moneyboats.com/");			
     
        //Maximize window		
        driver.manage().window().maximize();		
        		
        //Vertical scroll down by 600  pixels		
        js.executeScript("window.scrollBy(0,600)");			
    }		
	
}
