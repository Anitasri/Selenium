package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore //Avoids the class in execution
public class TestNGIgnoreDemo {

	//@Ignore- Avoids the method
	@Test
	public void test1() {
		
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {

		System.out.println("Test2");
	}

	@Test
	public void test3() {

		System.out.println("Test3");
	}
}
