import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ToScreenShot {

	@Test
	public void takeSnapshot( ) throws Exception{
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        //goto url
        driver.get("http://demo.guru99.com/V4/");
        
        //call the screenshot function
        this.takeScreenshotFunction(driver,"c://screenshot.png");
        
	}
	
	public void takeScreenshotFunction(WebDriver driver,String fileWithPath) throws IOException {
		
		 //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
		
	}
}
