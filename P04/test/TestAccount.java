package test;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

public class TestAccount
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		// Test subclasses now that Account is abstract
		Alacarte account1 = new Alacarte(); // Should be 1
		Unlimited account2 = new Unlimited(); // Should be 2
		int account1Expected = 2;
		int account2Expected = 3;
		
		if (account1.getAccountNumber() != account1Expected)
		{
			System.err.println("FAIL: Expected Account Number - " + account1Expected + " | Actual Account Number - " + account1.getAccountNumber());
			failureCount++;
		}
		
		if (account2.getAccountNumber() != account2Expected)
		{
			System.err.println("FAIL: Expected Account Number - " + account2Expected + " | Actual Account Number - " + account2.getAccountNumber());
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
