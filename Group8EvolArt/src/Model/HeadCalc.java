package Model;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import Stage2.Pair;
/**
 * Calculator class for generating points to draw the head shape.
 * @author Josh Merritt, Sheraz Atiq, Aman Kauldhar
 *
 */
public class HeadCalc {

	/**
	 * Number of points used to create the head. Initialised to 10.
	 */
	private int headPoints = 10;
	/**
	 * Head width, initialised to 300.
	 */
	private int headWidth = 300;
	/**
	 * Head height, initialised to 500.
	 */
	private int headHeight = 500;
	/**
	 * Integer to set centre of canvas to draw upon
	 */
	private int ORIGIN = 350;
	
	/**
	 * Constructor for HeadCalc. Takes parameters to determine mutation.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public HeadCalc(int i, boolean b, int p) {
		if (!b) {

			if (i == 1 || i == 6) {
				this.headWidth = 400;
			} else if (i == 3 || i == 4) {
				this.headHeight = 370;
			} else if (i == 2 || i == 5) {
				this.headHeight = 370;
				this.headWidth = 400;
				this.headPoints = 13;
			} else if (i == 8 || i == 9) {
				this.headHeight = 350;
			}

		} else {
			if (p == 1) {
				headWidth = 400;
				headHeight = 500;
				
			}
			if (p == 2) {
				headWidth = 450;
				headHeight = 400;
				
			}
			if (p == 3) {
				headHeight = 380;
			}
			if (p == 4) {
				headWidth = 350;
				headHeight = 400;
			}
			if (p == 5) {
				headHeight = 500;
			}
			if (p == 6) {
				headWidth = 450;
			}
			if (p == 7) {
				headWidth = 400;
				headHeight = 450;
				
			}
			if (p == 8) {
				headWidth = 300;
			}
			if (p == 9) {
				headHeight = 500;
			}

		}
	}
	
	/**
	 * Method to set the three attributes for an head (points, width, and height).
	 * @param attribs An array of three integers corresponding to each attribute
	 */
	public void setAttribs(int[] attribs) {
		headPoints = attribs[0];
		headWidth = attribs[1];
		headHeight = attribs[2];
	}

	/**
	 * Getter method for head points
	 */
	public int getHeadPoints() {
		return headPoints;
	}

	/**
	 * Getter method for head width
	 */
	public int getHeadWidth() {
		return headWidth;
	}

	/**
	 * Getter method for head height
	 */
	public int getHeadHeight() {
		return headHeight;
	}

	/**
	 * Calculator method generating a polygon that is the head's shape. Similar to the eyes in using maths functions to create the ellipse.
	 * @return A Polygon representing the head of the biomorph
	 */
	public Polygon getHeadShape() {
		Polygon result = new Polygon();
		for (int i = 0; i < headPoints; i++) {
			double percentDone = ((double) i) / ((double) headPoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN + (int) (headWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN + (int) (headHeight / 2 * Math.sin(currentEllipseAngle));

			result.addPoint(newPoint.x, newPoint.y);
		}
		return result;
	}
}
