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
		
		
		System.exit(failureCount);
	}
}
