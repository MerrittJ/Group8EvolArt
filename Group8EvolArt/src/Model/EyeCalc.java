package Model;

import java.awt.Point;
import java.awt.Polygon; //has contains() method, helpful for boundary checks!

import Stage2.Pair;

/**
 * Calculator class for generating points to draw the eyes of the face.
 * @author Josh Merritt, Sheraz Atiq, Aman Kauldhar
 *
 */
public class EyeCalc {

	/**
	 * Eye width with an initial value of 95
	 */
	private int eyeWidth = 95;
	/**
	 * Eye height with an initial value of 50
	 */
	private int eyeHeight = 50;
	/**
	 * The number of points joined to create the eye, initialised with 8 but not altered in the program
	 */
	private int eyePoints = 8;
	/**
	 * The horizontal distance between the eyes, initialised at 100 but not altered in the program
	 */
	private int xDistance = 100;
	/**
	 * Integer to act as centre of canvas for drawing
	 */
	private int ORIGIN = 350;

	/**
	 * Constructor for EyeCalc. Takes parameters to determine mutation.
	 * 
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public EyeCalc(int i, boolean b, int p) {

		if (!b) {
			if (i == 3 || i == 4 || i == 5) {
				this.eyeHeight = 100;
			}
		} else {
			if (p == 1 || p==5 || p==7) {
				if (i == 2) {
					this.eyeHeight = 75;
				}
				if (i == 4) {
					this.eyeHeight = 90;
				}
				if (i == 8) {
					this.eyeHeight = 60;
				}
			}
			if (p == 2|| p==6|| p==8|| p == 4) {
				if (i == 1) {
					this.eyeHeight = 75;
				}
				if (i == 5) {
					this.eyeHeight = 90;
				}
				if (i == 9) {
					this.eyeHeight = 60;
				}
			}
			if (p == 3 || p==9) {
				if (i == 3) {
					this.eyeHeight = 75;
				}
				if (i == 6) {
					this.eyeHeight = 90;
				}
				if (i == 8) {
					this.eyeHeight = 60;
				}
			}

		}

	}

	/**
	 * Method to set the four attributes for an eyes (width, height, number of points, and distance between them).
	 * @param attribs An array of four integers corresponding to each attribute
	 */
	public void setAttribs(int[] attribs) {
		eyeWidth = attribs[0];
		eyeHeight = attribs[1];
		eyePoints = attribs[2];
		xDistance = attribs[3];
	}

	/**
	 * Getter method for eye width
	 */
	public int getEyeWidth() {
		return eyeWidth;
	}

	/**
	 * Getter method for eye height
	 */
	public int getEyeHeight() {
		return eyeHeight;
	}

	/**
	 * Getter method for eye points
	 */
	public int getEyePoints() {
		return eyePoints;
	}

	/**
	 * Calculator method for drawing the eye points. An eye is a polygon, specifically an ellipse, created using maths functions
	 * @return a Pair object of two Polygons (right and left eyes)
	 */
	public Pair<Polygon, Polygon> getAllEyePoints() {
		Pair<Polygon, Polygon> result = new Pair<Polygon, Polygon>();

		Polygon eye1 = new Polygon();
		for (int i = 0; i < eyePoints; i++) {
			double percentDone = ((double) i) / ((double) eyePoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN + (xDistance / 2) + (int) (eyeWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN + (int) (eyeHeight / 2 * Math.sin(currentEllipseAngle));

			eye1.addPoint(newPoint.x, newPoint.y);
		}

		Polygon eye2 = new Polygon();
		for (int i = 0; i < eyePoints; i++) {
			double percentDone = ((double) i) / ((double) eyePoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN - (xDistance / 2) + (int) (eyeWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN + (int) (eyeHeight / 2 * Math.sin(currentEllipseAngle));

			eye2.addPoint(newPoint.x, newPoint.y);
		}

		result.x = eye1;
		result.y = eye2;
		return result;
	}
}