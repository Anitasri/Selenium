 package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	
	@Parameters({"MyName"})
	@Test
	public void test(@Optional("Ram") String name) {
		
		System.out.println("Name:" +name);
	}

}
