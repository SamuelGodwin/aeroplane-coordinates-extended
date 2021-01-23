/**
 * 
 */
package assessment;

/**
 * @author Samuel
 * 
 * This class models the runway in my solution. It has 2 fields; length and width.
 * It contains two accessor methods.
 * This class and its methods are public, so are accessible anywhere.
 *
 */

public class Runway {
	private final int length;
	private final int width;
	
	/**
	 * 
	 * @param length
	 * @param width
	 */
	public Runway(int length, int width) {

		this.length = length; // length of runway
		this.width = width; // width of runway
		
	}
	
	/**
	 * 'getLength'. This is an accessor method for the length field.
	 * @return length
	 */
	public int getLength() {
		
		return length;
		
	}
	/**
	 * 'getWidth'. This is an accessor method for the width field.
	 * @return width
	 */
	public int getWidth() {
		
		return width;
		
	}
}
