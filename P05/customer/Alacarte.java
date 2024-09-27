/**
 * Rerepresents an alacarte account type with point restrictions to playing media
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package customer;

import product.Media;

public class Alacarte extends Account
{
	private int pointsRemaining;
	
	/**
	 * Adds the number of points to the points remaining balance
	 *
	 * @param points	the number of points to be added
	 * @since		1.0
	 */
	public void buyPoints(int points)
	{
		pointsRemaining += points;
	}
	
	/**
	 * Returns the number of points remaining in the account 
	 * 
	 * @return	the number of points remaining in the account
	 * @since	1.0
	 */
	public int getPointsRemaining()
	{
		return pointsRemaining;
	}
	
	/**
	 * Returns a message displaying the media to be played depending on the student's points
	 * 
	 * @param media		the media to be played
	 * @return		a string displaying the media to be played and the points required if the student doesn't have enough
	 * @since 		1.0
	 */
	@Override
	public String play(Media media)
	{
		if (pointsRemaining >= media.getPoints())
		{
			pointsRemaining -= media.getPoints();
			return "Playing " + media;
		}
		else
		{
			return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
		}
	}
}
