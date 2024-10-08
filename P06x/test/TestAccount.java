package test;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class TestAccount
{
	public static void main(String[] args)
	{
		int failureCount = 0;
		
		// Test subclasses now that Account is abstract
		Alacarte account1 = new Alacarte(); // Should be 1
		Unlimited account2 = new Unlimited(); // Should be 2
		int account1Expected = 1;
		int account2Expected = 2;
		
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
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) 
		{
		        account1.save(bw);
		        account2.save(bw);
            	}
            	catch (IOException e)
		{
			System.err.println("Error writing to file: " + e.getMessage());
			failureCount++;
		}
            	
            	Alacarte loadedAccount1 = null;
            	Unlimited loadedAccount2 = null;
            	try (BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) 
            	{
		        loadedAccount1 = new Alacarte(br);
		        loadedAccount2 = new Unlimited(br);
            	}
            	catch (IOException e)
            	{
            		System.err.println("Error reading from file: " + e.getMessage());
			failureCount++;
            	}
            	
            	if ((account1.getAccountNumber() != loadedAccount1.getAccountNumber() || account2.getAccountNumber() != loadedAccount2.getAccountNumber()))
            	{
            		System.err.println("Original and loaded accounts are not equal");
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
