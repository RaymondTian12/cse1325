public class Purse
{
	public static void main(String[] args)
	{
		Coin[] coins = new Coin[5];
		coins[0] = new Coin(Denomination.PENNY, 1900);
		coins[1] = new Coin(Denomination.NICKEL, 1928);
		coins[2] = new Coin(Denomination.DIME, 1958);
		coins[3] = new Coin(Denomination.QUARTER, 1977);
		coins[4] = new Coin(Denomination.QUARTER, 2000);
		
		double totalValue = 0;
		double totalWeight = 0;
		int earliestDate = 2024; // Latest possible year
		int latestDate = 1776; // Earliest possible year
		
		for (Coin coin : coins)
		{
			System.out.println(coin);
			totalValue += coin.getValue();
			totalWeight += coin.getWeight();
			if (coin.getYear() < earliestDate)
			{
				earliestDate = coin.getYear();
			}
			if (coin.getYear() > latestDate)
			{
				latestDate = coin.getYear();
			}

		}
		
		System.out.printf("The total value of your purse is: $%.2f and weighs %.3f grams\n" , totalValue, totalWeight);
		System.out.println("Earliest Year: " + earliestDate);
		System.out.print("Latest Year: "+ latestDate);
	}
}
