package Model;

import java.util.HashMap;

import Stage2.Pair;

/**
 * Calculator class for generating the points representing the mouth.
 * @author Josh Merritt, Sheraz Atiq, Aman Kauldhar
 *
 */
public class MouthCalc {

	/**
	 * Width of the 'middle' line of the mouth. Initialised to 50 but not changed in the course of the program
	 */
	private int mouthMidWidth = 50;
	/**
	 * Width of each 'side' line of the mouth. Initialised to 50 but not changed in the course of the program
	 */
	private int mouthSideWidth = 50;
	/**
	 * Height of the mouth. Observed by the gradient of the 'side' lines. A positive value is a smile and a negative value is a frown. Initialised to 50.
	 */
	private int mouthHeight = 50;
	/**
	 * Integer to set centre of canvas to draw upon
	 */
	private int ORIGIN = 350;

	/**
	 * Constructor for MouthCalc. Takes parameters to determine mutation.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public MouthCalc(int i, boolean b, int p) {
		if (!b) {
			if (i == 7 || i == 6) {
				this.mouthHeight = 100;
			}
		} else {
			if (p == 1 || p == 6 || p == 9) {
				if (i == 1) {
					this.mouthHeight = 75;
				}
				if (i == 5) {
					this.mouthHeight = 90;
				}
				if (i == 9) {
					this.mouthHeight = 60;
				}
			}
			if (p == 2 || p == 8 || p == 4) {
				if (i == 2) {
					this.mouthHeight = 75;
				}
				if (i == 4) {
					this.mouthHeight = 90;
				}
				if (i == 8) {
					this.mouthHeight = 60;
				}
			}
			if (p == 3 || p == 7 || p == 5) {
				if (i == 4) {
					this.mouthHeight = 75;
				}
				if (i == 7) {
					this.mouthHeight = 90;
				}
				if (i == 9) {
					this.mouthHeight = 60;
				}
			}

		}

	}

	/**
	 * Method to set the three attributes for a mouth (midWidth, sideWidth, and height).
	 * @param attribs An array of three integers corresponding to each attribute
	 */
	public void setAttribs(int[] attribs) {
		mouthMidWidth = attribs[0];
		mouthSideWidth = attribs[1];
		mouthHeight = attribs[2];
	}

	/**
	 * Getter method for middle line width
	 */
	public int getMouthMidWidth() {
		return mouthMidWidth;
	}

	/**
	 * Getter method for side line width
	 */
	public int getMouthSideWidth() {
		return mouthSideWidth;
	}

	/**
	 * Getter method for mouth height
	 */
	public int getMouthHeight() {
		return mouthHeight;
	}

	/**
	 * Calculator method to generate the points for the mouth. Mouth is comprised of 4 lines, a right middle and side, and a left middle and side but will appear as three due to the middle lines appearing straight.
	 * @return a Pair object of HashMaps, each with an integer key and Integer, Integer Pair value
	 */
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getMouthPoints() {
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allPoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();

		HashMap<Integer, Pair<Integer, Integer>> right = new HashMap<Integer, Pair<Integer, Integer>>();
		HashMap<Integer, Pair<Integer, Integer>> left = new HashMap<Integer, Pair<Integer, Integer>>();

		// draw right mid + side
		Pair<Integer, Integer> r1 = new Pair<Integer, Integer>();

		r1.x = ORIGIN;
		r1.y = ORIGIN + 100; // starting point
		right.put(0, r1);

		Pair<Integer, Integer> r2 = new Pair<Integer, Integer>();
		r2.x = r1.x + mouthMidWidth / 2;
		r2.y = r1.y;
		right.put(1, r2);

		Pair<Integer, Integer> r3 = new Pair<Integer, Integer>();
		r3.x = r2.x + mouthSideWidth;
		r3.y = r1.y - mouthHeight;
		right.put(2, r3);

		// draw left mid + side
		Pair<Integer, Integer> l1 = new Pair<Integer, Integer>();

		l1.x = ORIGIN;
		l1.y = ORIGIN + 100; // starting point
		left.put(0, l1);

		Pair<Integer, Integer> l2 = new Pair<Integer, Integer>();
		l2.x = l1.x - mouthMidWidth / 2;
		l2.y = l1.y;
		left.put(1, l2);

		Pair<Integer, Integer> l3 = new Pair<Integer, Integer>();
		l3.x = l2.x - mouthSideWidth;
		l3.y = l1.y - mouthHeight;
		left.put(2, l3);

		allPoints.x = right;
		allPoints.y = left;
		return allPoints;
	}

}
