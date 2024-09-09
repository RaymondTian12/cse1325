public class TestStudent
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		Student student = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu"); // Test data
		
		if (!(student.toString()).equals("Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)"))
		{
			System.err.println("FAIL: Expected \"Raymond Tian (1002199181, rxt9181@mavs.uta.edu, Account #1)\" not \"" + student.toString() + "\"");
			failureCount++;
		}
		
		try
		{
			Student nonStudent = new Student("Raymond Tian", 1002199181, "rxt9181@gmail.com"); // Test data
			// If the following 2 lines are executed, then that means the exception was not thrown
			System.err.println("FAIL: Expected Illegal Argument Exception for Non-UTA email adddress"); 
			failureCount++;
		}
		catch(IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			failureCount++;
		}
		catch(Exception e)
		{
			System.err.println("FAIL: Unexpected exception type");
			failureCount++;
		}
		
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
		
		if (!(student.requestMedia(media)).equals("Playing " + media.toString()))
		{
			System.err.println("FAIL: Expected \"" + media.toString() + "\" not \"" + student.requestMedia(media) + "\"");
			failureCount++;
		}
		
		System.exit(failureCount);
	}
}
