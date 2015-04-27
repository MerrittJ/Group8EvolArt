package Model;

import java.awt.Point;
import java.awt.Polygon; //has contains() method, helpful for boundary checks!

import Stage2.Pair;

public class EyeCalc {

	private int ORIGIN = 350;
	private int eyeWidth = 95;
	private int eyeHeight = 50;
	private int eyePoints = 8;
	private int xDistance = 100;

	/**
	 * Eye generatic calculation logic
	 * 
	 * @param i
	 * @param b
	 * @param p
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

	public void setAttribs(int[] attribs) {
		eyeWidth = attribs[0];
		eyeHeight = attribs[1];
		eyePoints = attribs[2];
		xDistance = attribs[3];
	}

	public int getEyeWidth() {
		return eyeWidth;
	}

	public int getEyeHeight() {
		return eyeHeight;
	}

	public int getEyePoints() {
		return eyePoints;
	}

	public Pair<Polygon, Polygon> getAllEyePoints() {
		Pair<Polygon, Polygon> result = new Pair<Polygon, Polygon>();

		Polygon eye1 = new Polygon();
		for (int i = 0; i < eyePoints; i++) {
			double percentDone = ((double) i) / ((double) eyePoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN + (xDistance / 2)
					+ (int) (eyeWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN
					+ (int) (eyeHeight / 2 * Math.sin(currentEllipseAngle));

			eye1.addPoint(newPoint.x, newPoint.y);
		}

		Polygon eye2 = new Polygon();
		for (int i = 0; i < eyePoints; i++) {
			double percentDone = ((double) i) / ((double) eyePoints);
			double currentEllipseAngle = percentDone * 2 * Math.PI;

			Point newPoint = new Point();
			newPoint.x = ORIGIN - (xDistance / 2)
					+ (int) (eyeWidth / 2 * Math.cos(currentEllipseAngle));
			newPoint.y = ORIGIN
					+ (int) (eyeHeight / 2 * Math.sin(currentEllipseAngle));

			eye2.addPoint(newPoint.x, newPoint.y);
		}

		result.x = eye1;
		result.y = eye2;
		return result;
	}
}