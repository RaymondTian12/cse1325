import java.util.Scanner;

public class Hello
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String userName = in.nextLine();
		System.out.println("hello, " + userName);
	}
}

