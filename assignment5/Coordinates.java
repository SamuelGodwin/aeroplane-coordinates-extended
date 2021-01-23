/**
 * 
 */
package assignment5;

/**
 * @author Samuel
 *
 * This class models the coordinates in my solution. It has 2 fields; x and y.
 * It is a reused class from a previous assignment; assignment5.
 * It contains mutator methods and accessor methods.
 * This class and its methods are public, so are accessible anywhere.
 *
 */

public class Coordinates {
	
	private int x;
	private int y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Coordinates(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	/**
	 * 
	 * @return x
	 */
	public int getX() {
		
		return x;
		
	}
	
	/**
	 * 
	 * @return y
	 */
	public int getY() {
		
		return y;
		
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		
		this.x = x;
		
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		
		this.y = y;
		
	}
	
}
