public class TestStudent
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		Student student = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu"); // Test data
		Account account = new Account(); // Test data
		
		if (!student.toString().equals("Raymond Tian (1002199181, rxt9181@mavsuta.edu, Account #" + account.getAccountNumber() + ")"));
		{
			System.err.println("FAIL: ");
			failureCount++;
		}
		
		
		System.exit(failureCount);
	}
}
