/**
 * Represents an alacarte account type with no restrictions to playing media
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package customer;

import product.Media;

public class Unlimited extends Account
{
	/**
	 * Returns a message displaying the media to be played with no restrictions
	 *
	 * @param media		the media to be played
	 * @return		a string displaying the media that will be played
	 * @since		1.0
	 */
	@Override
	public String play(Media media)
	{
		return "Playing " + media.toString();
	}
}
