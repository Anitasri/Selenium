package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	/*public static void main(String[] args) {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);

		System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();

		driver.get(baseUrl);           
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		WebElement td_Home = driver
				.findElement(By
						.xpath("//html/body/div"
								+ "/table/tbody/tr/td"
								+ "/table/tbody/tr/td"
								+ "/table/tbody/tr/td"
								+ "/table/tbody/tr"));    

		Actions builder = new Actions(driver);
		Action mouseOverHome = builder
				.moveToElement(link_Home)
				.build();

		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);        
		mouseOverHome.perform();        
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("After hover: " + bgColor);
		//driver.close();
	}*/

	public static void main(String[] args) {
		String baseUrl = "http://www.facebook.com/"; 
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);

		System.setProperty("webdriver.gecko.driver",projectPath +"//drivers/geckodriver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get(baseUrl);
		WebElement emailName = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(emailName)
				.click()
				.keyDown(emailName, Keys.SHIFT)
				.sendKeys(emailName, "hello")
				.keyUp(emailName, Keys.SHIFT)
				.doubleClick(emailName)
				.contextClick()
				.build();

		seriesOfActions.perform() ;

	}
}