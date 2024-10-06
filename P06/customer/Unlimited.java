/**
 * Represents an unlimited account type with no restrictions to playing media
 *
 * @author	Raymond Tian
 * @version	1.0
 * @since	1.0
 */

package customer;

import product.Media;

// New imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Unlimited extends Account
{
	
	public void save(BufferedWriter bw) throws IOException
	{
		super.save(bw);
	}
	
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
