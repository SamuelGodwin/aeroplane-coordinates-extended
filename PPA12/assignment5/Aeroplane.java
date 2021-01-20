/**
 * 
 */
package assignment5;

/**
 * @author Samuel & Anttoni
 * 
 * This class models the aeroplane in our solution. It has 4 fields; name, coordinates, speed & totalDistance.
 * It is a reused class from a previous assignment; assignment5.
 * It contains mutator methods and accessor methods.
 * This class and its methods are public, so are accessible anywhere.
 *
 */

public class Aeroplane {

	private String name;
	private Coordinates coordinates;
	private int speed;
	private int totalDistance;
	
	/**
	 * 
	 * removed name, repairDistance parameters from original assignment version.
	 * @param coordinates
	 * @param speed
	 * @param totalDistance
	 */
	public Aeroplane(Coordinates coordinates, int speed, int totalDistance) {
		
		//this.name = name;
		this.coordinates = coordinates;
		this.speed = speed;
		this.totalDistance = totalDistance;
		//this.repairDistance = repairDistance;
		
	}
	
	/**
	 * 'getName'. This is an accessor method for the name field.
	 * @return
	 */
	public String getName() {
		
		return name;
		
	}
	
	/**
	 * 'getCoordinates'. This is an accessor method for the coordinates field.
	 * @return
	 */
	public Coordinates getCoordinates() {
		
		return coordinates;
		
	}
	
	/**
	 * 'getSpeed'. This is an accessor method for the speed field.
	 * @return speed
	 */
	public int getSpeed() {
		
		return speed;
		
	}
	
	/**
	 * 'getTotalDistance'. This is an accessor method for the totalDistance field.
	 * @return totalDistance
	 */
	public int getTotalDistance() {
		
		return totalDistance;
		
	}
	
	/**
	 * 'getX'. This avoids violation of Demeter's law.
	 * @return coordinates.getX().
	 */
	public int getX()
	{
		return coordinates.getX();
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	/**
	 * 
	 * @param coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		
		this.coordinates = coordinates;
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setCoordinates(int x, int y) {
		
		this.coordinates = new Coordinates(x , y);
		
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		
		this.speed = speed;
		
	}
	
	/**
	 * 
	 * @param totalDistance
	 */
	public void setTotalDistance(int totalDistance) {
		
		this.totalDistance = totalDistance;
		
	}
}
