public class Purse
{
	public static void main(String[] args)
	{
		Coin[] coins = new Coin[5];
		coins[0] = new Coin(Denomination.PENNY, 1900);
		coins[1] = new Coin(Denomination.NICKEL, 1928);
		coins[2] = new Coin(Denonination.DIME, 1958);
		coins[3] = new Coin(Denomination.QUARTER, 1977);
		coins[5] = new Coin(Denomination.QUARTER, 2000);
		
		double totalValue = 0;
		int earliestDate = 2024; // Latest possible year
		int latestDate = 
		
		for (Coin coin : coins)
		{
			totalValue += coin.getValue();
			if (coin.getValue() < earliestDate)
			{
				earliestDate = coin.getValue();
			}
			if (coin.getValue() > latestDate)
			{
				latestDate = coin.getValue();
			}

		}
		
		System.out.println("The total value of your purse is:  " + totalValue);
		System.outprintln("Earliest Year: " + earliestDate);
		System.out.print("Latest Year: "+ latestDate);
	}
}
