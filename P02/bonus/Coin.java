public class Coin
{
	private Denomination denomination;
	private int year;
	
	public coin(Denomination denomination, int year)
	{
		this.denomination = denomination;
		this.year = year;
	}
	
	public double getValue()
	{
		return denomination.getValue();
	}
	
	
}

