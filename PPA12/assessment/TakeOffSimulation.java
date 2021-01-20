/**
 * 
 */
package assessment;

/**
 * @author Samuel & Anttoni
 *
 *         'Main' class. This is the driver class for our PPA12 solution. It
 *         contains our 'main' method. This class is the only class that is to
 *         be compiled and run directly, as the compiler will automatically
 *         compile our other referenced classes. This class and its method are
 *         public, so are accessible anywhere.
 *         
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import assignment5.Aeroplane;
import assignment5.Coordinates;

public class TakeOffSimulation extends JFrame {

	private static Runway runway;
	private static int startX;

	private static Aeroplane aeroplane;

	JSlider jsHorizontal = new JSlider(0, runway.getWidth(), startX); // Horizontal
																		// slider
																		// set
																		// to be
																		// between
																		// 0 and
																		// runway's
																		// length,
																		// default
																		// is in
																		// the
																		// middle
	JSlider jsVertical = new JSlider(JSlider.VERTICAL, 0, 10, 0); // Vertical
																	// slider
																	// set to be
																	// between 0
																	// and 10,
																	// plane is
																	// by
																	// default
																	// at 0
	JTextArea jtDisplay = new JTextArea(15, 30); // Sets text display to desired
													// size

	int seconds = 0; // Second counter

	int elevationCounter = 0; // Creates counter
	int elevation = 0; // needs resets

	/**
	 * Constructs simulation, based on JFrame class
	 */
	public TakeOffSimulation() {
		super("My Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initWidgets();
	}

	/**
	 * Creates widjets to fill Java Frame
	 */
	private void initWidgets() {
		this.setSize(600, 800);

		// Code for the contents of the frame below
		JScrollPane jspDisplay = new JScrollPane(jtDisplay);

		JButton jbReset = new JButton("Reset");
		// GUIListener listener = new GUIListener(jsVertical, jsHorizontal,
		// jtDisplay)

		/**
		 * 
		 * @author Samuel & Anttoni
		 * 
		 * Inner class that provides reseting functionality to reset button, using ActionListener interface
		 *
		 */
		class GUIListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {

				// 1. Set the sliders to default (0 and startX)
				jsVertical.setValue(0);
				jsHorizontal.setValue(startX);
				// 2. Set the TextArea to have no text
				jtDisplay.setText("");
				
				// 3. Set seconds back to 0
				seconds = 0;
				
				// 4. Set aeroplane fields back to default
				aeroplane.setTotalDistance(0);
				aeroplane.setCoordinates(0, 0);
				aeroplane.setSpeed(0);

				// 5. Set elevation fields back to 0
				elevationCounter = 0;
				elevation = 0;
			}

		}

		// Create Over-arching Border Layout
		this.setLayout(new BorderLayout());
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		this.add(jpCenter, BorderLayout.CENTER);
		this.add(jpSouth, BorderLayout.SOUTH);

		// Create Grid Layout for centre layout
		jpCenter.setLayout(new GridLayout(1, 1));
		jpCenter.add(jspDisplay);

		// Create Border Layout for south layout
		jpSouth.setLayout(new BorderLayout());
		JPanel jpSNorth = new JPanel();
		JPanel jpSCenter = new JPanel();
		JPanel jpSSouth = new JPanel();
		jpSouth.add(jpSNorth, BorderLayout.NORTH);
		jpSouth.add(jpSCenter, BorderLayout.CENTER);
		jpSouth.add(jpSSouth, BorderLayout.SOUTH);

		jpSNorth.add(jsHorizontal);
		jpSCenter.add(jsVertical);
		jpSSouth.add(jbReset);

		// Add action listener for reset button
		jbReset.addActionListener(new GUIListener());

		// Pack frame
		this.pack();

		// Set frame to visible
		this.setVisible(true);

		// Call method to perform simulation
		aeroplaneTakeOff();

	}

	/**
	 *  Performs simulation of aeroplane take off
	 */
	private void aeroplaneTakeOff() {
		do {
			if (aeroplane.getTotalDistance() <= runway.getLength() + aeroplane.getSpeed()) { // flag
																								// to
																								// ensure
																								// plane
																								// is
																								// inside
																								// runway
				aeroplane.setSpeed(jsVertical.getValue());
				aeroplane.setCoordinates(jsHorizontal.getValue(), aeroplane.getTotalDistance());

				// If aeroplane speed is 10 elevation counter starts counting
				if (aeroplane.getSpeed() == 10) {
					elevationCounter++;
				} else {
					elevationCounter = 0;
				}
				
				// If elevation counter reaches 5, elevation begins
				if (elevationCounter >= 5) {
					elevation++;
				}

				// Displays current status
				jtDisplay.append(
						"Seconds: " + seconds + "\nSpeed: " + aeroplane.getSpeed() + " X: " + jsHorizontal.getValue()
								+ " Y: " + aeroplane.getTotalDistance() + " Elevation: " + elevation + "\n");

				// Once aeroplane exceeds runway distance, evaluation of take off begins
				if (aeroplane.getTotalDistance() >= runway.getLength()) { //
					if (elevation >= 5 && aeroplane.getX() == startX) { // If aeroplane above set elevation and at centre of runway, take off successful
						jtDisplay.append("Flight Successful"); // Displays whether flight successful
						aeroplane.setTotalDistance(aeroplane.getTotalDistance() + 11); // ensures
																						// that
																						// plane
																						// is
																						// taken
																						// out
																						// of
																						// the
																						// runway

					} else {
						jtDisplay.append("Flight not Successful"); // Displays whether flight successful
						aeroplane.setTotalDistance(aeroplane.getTotalDistance() + 11); // ensures
																						// that
																						// plane
																						// is
																						// taken
																						// out
																						// of
																						// the
																						// runway
					}
				} else
					aeroplane.setTotalDistance(aeroplane.getTotalDistance() + aeroplane.getSpeed()); // Increases distance of plane on runway based on speed
			}
			try {
				Thread.sleep(1000); // Sleeps for 1 second
			} catch (InterruptedException e) {
			}

			seconds++; // Increases second counter
		} while (true); // Infinite loop

	}

	/**
	 * Main method. Created runway and aeroplane objects to represent simulation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		runway = new Runway(100, 10);
		// private int initialX = runway.getWidth() / 2;

		startX = runway.getWidth() / 2;

		Coordinates coordinates = new Coordinates(startX, 0);

		// CHECK parameters, can we change them in Aeroplane does this still
		// count as 'reuse class'
		aeroplane = new Aeroplane(coordinates, 0, 0);

		new TakeOffSimulation().setVisible(true);

	}

}