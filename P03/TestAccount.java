public class TestAccount
{
	public static void main(String[] args)
	{
		Account account1 = new Account(); // Should be 1
		Account account2 = new Account(); // Should be 2
		int account1Expected = 1;
		int account2Expected = 2;
		
		if (account1.getAccountNumber() != account1Expected)
		{
			System.err.println("FAIL: Expected Account Number - " + account1Expected + " | Actual Account Number - " + account1.getAccountNumber());
			System.exit(-1);
		}
		
		if (account2.getAccountNumber() != account2Expected)
		{
			System.err.println("FAIL: Expected Account Number - " + account2Expected + " | Actual Account Number - " + account2.getAccountNumber());
			System.exit(-1);
		}
	}
}
