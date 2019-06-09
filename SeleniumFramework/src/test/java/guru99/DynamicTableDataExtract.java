package guru99;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableDataExtract {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath:"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath +"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Find the base table using xpath
		WebElement baseTable= driver.findElement(By.xpath("//html/body/table/tbody"));
		//Find the table rows
		List<WebElement> rowsTable= baseTable.findElements(By.tagName("tr"));
		int rowCount= rowsTable.size();
		System.out.println("No of rows in a table:"+rowCount);
		
		//find the no. of columns in a each row using loop
		for(int row=0;row<rowCount;row++) 
		{
			List<WebElement> columnsRow=rowsTable.get(row).findElements(By.tagName("td"));
			int colCount=columnsRow.size();
			System.out.println("No of columns in row" +row+"are" +colCount);
			
			//find the column rows data
			for(int col=0;col<colCount;col++)
			{
				String cellText= columnsRow.get(col).getText();
				System.out.println("Cell text of row" +row+ "And column"+col+"are:"+cellText);
				
			}
			System.out.println("--------------------------------------------------");	
		}
		
	}

}
