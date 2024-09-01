public enum Denomination
{
	PENNY,
	NICKEL,
	DIME,
	QUARTER;
	
	private double value;
	private Denomination(double value)
	{
		this.value = value;
	}
	
	public double getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}
