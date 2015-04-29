package Model;


import java.util.HashMap;

import Stage2.Pair;

/**
 * Calculator class for generating points to draw the eyebrows of the face. 
 * @author Josh Merritt, Sheraz Atiq, Aman Kauldhar
 */
public class EyebrowCalc {

	/**
	 * Eyebrow width with initial setting of 100
	 */
	private int eyebrowWidth = 100;
	/**
	 * Eyebrow height with initial setting of 50
	 */
	private int eyebrowHeight = 50;
	/**
	 * Horizontal distance between the eyebrows. Not altered in course of program.
	 */
	private int eyebrowDistance = 100;
	/**
	 * Integer to set centre of canvas to draw upon
	 */
	private int ORIGIN = 350; 

	/**
	 * Constructor for EyebrowCalc. Takes parameters to determine mutation.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public EyebrowCalc(int i, boolean b, int p) {
		if (b) {
			if (p == 1 || p == 7 || p == 9) {
				if (i == 3) {
					this.eyebrowHeight = 75;
				}
				if (i == 6) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 150;
				}
				if (i == 7) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 50;
				}
			}
			if (p == 3 || p == 8 || p == 5 || p == 4) {
				if (i == 1) {
					this.eyebrowHeight = 75;
				}
				if (i == 5) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 75;
				}
				if (i == 2) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 80;
				}
			}
			if (p == 2 || p == 6) {
				if (i == 3) {
					this.eyebrowHeight = 75;
				}
				if (i == 6) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 50;
				}
				if (i == 7) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 40;
				}
			}

		} else {
			if (i == 3) {
				this.eyebrowHeight = 75;
			}
			if (i == 6) {
				this.eyebrowHeight = 90;
				this.eyebrowWidth = 50;
			}
			if (i == 7) {
				this.eyebrowHeight = 60;
				this.eyebrowWidth = 40;
			}
		}

	}

	/**
	 * Method to set the three attributes for an eyebrow (width, height, and distance).
	 * @param attribs An array of three integers corresponding to each attribute
	 */
	public void setAttribs(int[] attribs) {
		eyebrowWidth = attribs[0];
		eyebrowHeight = attribs[1];
		eyebrowDistance = attribs[2];

	}

	/**
	 * Getter method for eyebrowWidth
	 */
	public int getEyebrowWidth() {
		return eyebrowWidth;
	}

	/**
	 * Getter method for eyebrowHeight
	 */
	public int getEyebrowHeight() {
		return eyebrowHeight;
	}

	/**
	 * Getter method for eyebrowDistance
	 */
	public int getEyebrowDistance() {
		return eyebrowDistance;
	}

	/**
	 * Calculator method to determine the points at which this particular set of eyebrows should be drawn. Draws a right and left eyebrow, each comprised of a single line between two points which can vary in width and height in this implementation.
	 * @return a Pair object of two HashMaps, each comprised of an integer key and an integer Pair object
	 */
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints() {
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allpoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();

		HashMap<Integer, Pair<Integer, Integer>> eyebrow = new HashMap<Integer, Pair<Integer, Integer>>();
		HashMap<Integer, Pair<Integer, Integer>> eyebrowM = new HashMap<Integer, Pair<Integer, Integer>>();

		// draw right eyebrow (2 points)
		Pair<Integer, Integer> ebr = new Pair<Integer, Integer>();
		ebr.x = ORIGIN + (eyebrowDistance / 2);
		ebr.y = ORIGIN - 100; // starting point
		eyebrow.put(0, ebr);

		Pair<Integer, Integer> ebr2 = new Pair<Integer, Integer>();
		ebr2.x = ebr.x + eyebrowWidth;
		ebr2.y = ebr.y - eyebrowHeight;
		eyebrow.put(1, ebr2);

		// draw left (2 points)
		Pair<Integer, Integer> ebl = new Pair<Integer, Integer>();
		ebl.x = ORIGIN - (eyebrowDistance / 2);
		ebl.y = ebr.y;
		eyebrowM.put(0, ebl);

		Pair<Integer, Integer> ebl2 = new Pair<Integer, Integer>();
		ebl2.x = ebl.x - eyebrowWidth;
		ebl2.y = ebl.y - eyebrowHeight;
		eyebrowM.put(1, ebl2);

		allpoints.x = eyebrow;
		allpoints.y = eyebrowM;
		return allpoints;
	}
}