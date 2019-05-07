package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	//@Test(dependsOnMethods= {"test2"})
	//@Test(dependsOnGroups= {"sanity1"})
	@Test(dependsOnGroups= {"sanity.*"})
	public void test1() {
		
		System.out.println("Test1");
	}
	
	@Test(groups= {"sanity1"})
	public void test2() {

		System.out.println("Test2");
	}

	@Test(groups= {"sanity2"})
	public void test3() {

		System.out.println("Test3");
	}
	
}
