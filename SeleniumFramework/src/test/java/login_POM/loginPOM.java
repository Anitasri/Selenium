package login_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPOM {

	WebDriver driver;
	
	By username=By.name("uid");
	By password=By.name("password");
    By login=By.name("btnLogin");
    By title= By.linkText("Guru99 Bank");
    
	public loginPOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUserName(String userName) {
		
		driver.findElement(username).sendKeys(userName);
	}
	
	public void setPassword(String passWord) {
		
		driver.findElement(password).sendKeys(passWord);
		
	}
	
	public void clickLogin() {
		
		driver.findElement(login).click();
	}
	
	public String getLoginPageTitle() {
		
		return driver.findElement(title).getText();
	}
	
	public void loginMethod(String userName,String passWord) {
		
		this.setUserName(userName);
		this.setPassword(passWord);
		this.clickLogin();
	}
	
}
