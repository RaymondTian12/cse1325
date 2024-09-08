public class TestAccount
{
	public static void main(String[] args)
	{
		Account account1 = new Account(); // Should be 1
		Account account2 = new Account(); // Should be 2
		
		if (account1.getAccountNumber() != 1)
		{
			System.err.println("FAIL: Expected Account Number - 1 " + "Actual Account Number - " + account1.getAccountNumber());
			System.exit(-1);
		}
		
		if (account2.getAccountNumber() != 2)
		{
			System.err.println("FAIL: Expected Account Number - 1 " + "Actual Account Number - " + account1.getAccountNumber());
			System.exit(-1);
		}
	}
}
