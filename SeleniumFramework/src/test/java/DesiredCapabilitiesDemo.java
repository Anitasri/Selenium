import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings",true);
		
		System.setProperty("webdriver.ie.driver",projectPath +"//drivers/iedriver/IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver(caps);
		
		//goto google.com
		driver.get("https://bing.com/");

		//enter text in search bar
		driver.findElement(By.id("sb_form_q")).sendKeys("Auto");

		//click on search button                                                                                                                                                                       
		driver.findElement(By.id("sb_form_go")).click();
        
		driver.close();
		driver.quit();

	}

}
