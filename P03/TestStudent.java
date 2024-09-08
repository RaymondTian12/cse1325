public class TestStudent
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		Student student = new Student("Raymond Tian", 1002199181, "rxt9181@mavs.uta.edu"); // Test data
		
		System.out.println(student.toString());
		
		/*if (!student.toString().equals("Raymond Tian (1002199181, rxt9181@mavsuta.edu, Account #" + student.account.getAccountNumber() + ")"));
		{
			
			failureCount++;
		}
		*/
		
		System.exit(failureCount);
	}
}
