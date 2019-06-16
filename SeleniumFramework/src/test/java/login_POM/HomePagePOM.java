package login_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePOM {

	WebDriver driver;
	
	By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	
	public HomePagePOM(WebDriver driver) {
	
		this.driver=driver;
		
	}
	
	public String getHomePageUserId() {
		
		return driver.findElement(homePageUserName).getText();
	}
	
}
