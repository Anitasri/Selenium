package demo;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {

	@Test(priority=1)
	public void one() {

		System.out.println("Test1");
	}

	@Test
	public void two() {

		System.out.println("Test2");
	}
	
	@Test(priority=2)
	public void three() {

		System.out.println("Test3");
	}
}
