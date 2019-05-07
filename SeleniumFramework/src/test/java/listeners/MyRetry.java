package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


	/*Sometimes, you might want TestNG to automatically retry a test whenever it fails. 
	 * In those situations, you can use a retry analyzer. When you bind a retry analyzer 
	 * to a test, TestNG automatically invokes the retry analyzer to determine if TestNG 
	 * can retry a test case again in an attempt to see if the test that just fails now
	 *  passes. Here is how you use a retry analyzer:
		Build an implementation of the interface org.testng.IRetryAnalyzer
		Bind this implementation to the @Test annotation for 
		e.g., @Test(retryAnalyzer = LocalRetry.class)
		Following is a sample implementation of the retry analyzer that retries a
		 test for a maximum of three times. */
		
		 
		public class MyRetry implements IRetryAnalyzer {
		 
		  private int retryCount = 0;
		  private static final int maxRetryCount = 3;
		 
		  public boolean retry(ITestResult result) {
		    if (retryCount < maxRetryCount) {
		      retryCount++;
		      return true;
		    }
		    return false;
		  }
		}


