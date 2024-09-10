public class TestStudent
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		// Test verifying student's toString() method
		Student student = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu"); 
		
		if (!(student.toString()).equals("Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)"))
		{
			System.err.println("FAIL: Expected \"Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)\" not \"" + student.toString() + "\"");
			failureCount++;
		}
		
		// Test verifying non-UTA email address
		String invalidEmail = "rxt9181@invalid.edu"; 
		try
		{
			Student invalidStudent = new Student("Raymond Tian", 1002199181, invalidEmail); 
			// If the following 2 lines are executed, then that means the exception was not thrown
			System.err.println("FAIL: Expected Illegal Argument Exception for Non-UTA email adddress " + invalidEmail); 
			failureCount++;
		}
		catch(IllegalArgumentException e)
		{
			// Catch and Ignore the correct exception
			if(!(e.getMessage()).equals("Non-UTA email address: " + invalidEmail)) 
			{
				System.err.println("FAIL: Incorrect exception message for invalid email address");
				System.err.println("Expected: Non-UTA email address: " + invalidEmail + " | Actual - " + e.getMessage());
				failureCount++;
			}
		}
		catch(Exception e)
		{
			System.err.println("FAIL: Unexpected exception type - " + e.getClass().getName());
			failureCount++;
		}
		
		// Test verifying requesting media
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
		
		if (!(student.requestMedia(media)).equals("Playing " + media.toString()))
		{
			System.err.println("FAIL: Expected \"" + media.toString() + "\" not \"" + student.requestMedia(media) + "\"");
			failureCount++;
		}
		
		if (failureCount > 0)
		{
			System.err.println("FAIL: Error code " + failureCount);
			System.exit(failureCount);
		}
		else
		{
			System.exit(0);
		}
	}
}
