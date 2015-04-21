package Model;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import Stage2.Pair;
/**
 * Class responsible for head calculations.
 * @author Mohammed, Sheraz, Aman, Josh
 */
public class HeadCalc {

	private int ORIGIN = 350;
	private int headPoints = 10;
	private int headWidth = 300;
	private int headHeight = 500;

	/**
	 * Head calculation logic
	 * 
	 * @param i
	 * @param b
	 * @param p
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
				headWidth = 400;
			}
			if (p == 5) {
				headHeight = 500;
			}
			if (p == 6) {
				headWidth = 350;
				headHeight = 400;
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

	public void setAttribs(int[] attribs) {
		headPoints = attribs[0];
		headWidth = attribs[1];
		headHeight = attribs[2];
	}

	public int getHeadPoints() {
		return headPoints;
	}

	public int getHeadWidth() {
		return headWidth;
	}

	public int getHeadHeight() {
		return headHeight;
	}

	public Polygon getHeadShape() {
		Polygon result = new Polygon();
		for (int i = 0; i < headPoints; i++) {
			double percentDone = ((double) i) / ((double) headPoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN
					+ (int) (headWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN
					+ (int) (headHeight / 2 * Math.sin(currentEllipseAngle));

			result.addPoint(newPoint.x, newPoint.y);
		}
		return result;
	}
}
