package Model;

import java.util.HashMap;

import Stage2.Pair;
/**
 * Calculator class for generating points to draw the nose.
 * @author Josh Merritt, Sheraz Atiq, Aman Kauldhar
 *
 */
public class NoseCalc {

	/**
	 * Vertical offset of nose from ORIGIN. In generation, the reference point for this value is the bottom of the nose.
	 */
	private int yOffset = -100;
	/**
	 * Length of the nose. A positive value will show a left pointing nose, whereas a negative value will produce a right pointing nose. Initialised to 20 but not changed in course of program.
	 */
	private int noseLength = 20;
	/**
	 * Rise of the nose, i.e. how 'upturned' it appears. Initialised to 10 but not changed in course of program.
	 */
	private int noseRise = 10;
	/**
	 * Height of the nose. Initialised to 80.
	 */
	private int noseHeight = 80;
	/**
	 * Integer to set centre of canvas to draw upon.
	 */
	private int ORIGIN = 350;

	/**
	 * Constructor for NoseCalc. Takes parameters to determine mutation.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public NoseCalc(int i, boolean b, int p) {
		if (b) {
			if (p == 1 || p == 6 || p == 5) {
				if (i == 3) {
					this.noseHeight = 75;
				}
				if (i == 6) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 7) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}
			if (p == 3 || p == 9 || p == 7) {
				if (i == 1) {
					this.noseHeight = 75;
				}
				if (i == 5) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 2) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}
			if (p == 2 || p == 8 || p == 4) {
				if (i == 3) {
					this.noseHeight = 75;
				}
				if (i == 6) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 7) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}

		}
	}

	/**
	 * Method to set the four attributes for an nose (yOffset, length, rise, and height).
	 * @param attribs An array of four integers corresponding to each attribute
	 */
	public void setAttribs(int[] attribs) {
		yOffset = attribs[0];
		noseLength = attribs[1];
		noseRise = attribs[2];
		noseHeight = attribs[3];
	}

	/**
	 * Getter method for Y offset
	 */
	public int getyOffset() {
		return yOffset;
	}

	/**
	 * Getter method for length
	 */
	public int getNoseLength() {
		return noseLength;
	}

	/**
	 * Getter method for rise
	 */
	public int getNoseRise() {
		return noseRise;
	}

	/**
	 * Calculator method to generate the points of the nose. The nose consists of three points, top, tip, and bottom.
	 * @return a HashMap with an integer key and integer integer Pair values
	 */
	public HashMap<Integer, Pair<Integer, Integer>> getNosePoints() {

		HashMap<Integer, Pair<Integer, Integer>> points = new HashMap<Integer, Pair<Integer, Integer>>();

		points.put(0, new Pair<Integer, Integer>(ORIGIN, (ORIGIN - yOffset - noseHeight))); // top of nose
		points.put(1, new Pair<Integer, Integer>((ORIGIN - noseLength), (ORIGIN - yOffset - noseRise))); // tip of nose
		points.put(2, new Pair<Integer, Integer>(ORIGIN, (ORIGIN - yOffset))); // bottom
																				// of
																				// nose

		return points;
	}

}
