package login_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	loginPOM objLogin;
	HomePagePOM objHome;
	
	@BeforeTest
	public void setUp() {
	
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
        
        driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/V4/");
		
	}
	
	@Test(priority=0)
	public void loginPageTest() {
		
		objLogin= new loginPOM(driver);
		
		//check the title of the login page
		Assert.assertTrue(objLogin.getLoginPageTitle().toLowerCase().contains("guru99 bank"));
		
		//login 
		objLogin.loginMethod("mngr201323", "guvUmyj");
		
		objHome=new HomePagePOM(driver);
		
		//Check the user of the home page
		Assert.assertTrue(objHome.getHomePageUserId().toLowerCase().contains("manger id:mngr201323"));
		
	}
	
}
