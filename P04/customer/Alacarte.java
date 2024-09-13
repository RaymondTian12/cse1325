package customer;

public class Alacarte extends Account
{
	private int pointsRemaining;
	
	public void buyPoints(int points)
	{
		pointsRemaining += points;
	}
	
	public int getPointsRemaining()
	{
		return pointsRemaining;
	}
	
	@Override
	public String play(Media media)
	{
		if (pointsRemaining >= media.getPoints())
		{
			pointsRemaining -= points;
			return "Playing" + media;
		}
		else
		{
			return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
		}
	}
}
