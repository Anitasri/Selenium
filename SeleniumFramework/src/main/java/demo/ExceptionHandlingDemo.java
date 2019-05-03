package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		demo();
	}


	public static void demo() {

		try {
			System.out.println("Hello");
			int i=1/0;
			System.out.println("Completed");
		}

		catch(Exception e) {

			System.out.println("Inisde catch block");
			System.out.println(e.getMessage());	
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		finally {

			System.out.println("Inside finally block");
		}
	}
}
