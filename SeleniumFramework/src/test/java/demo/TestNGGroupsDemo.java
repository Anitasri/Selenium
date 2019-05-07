package demo;

import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups={"linux.sanity"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups={"sanity","smoke"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups={"sanity","regression"})
	public void test3() {
		System.out.println("Test3");
	}
	
	@Test(groups={"windows.regression"})
	public void test4() {
		System.out.println("Test4");
	}
}
