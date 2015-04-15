package Model;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import Stage2.Pair;

public class HeadCalc {

	private int ORIGIN = 350;
	private int headPoints; // = 10;
	private int headWidth ;// = 300;
	private int headHeight; //= 500;
	
	public HeadCalc() {
		
	}
	
	public void setAttribs(int[] attribs){
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
	
	
	public Polygon getHeadShape()
	{
	    Polygon result = new Polygon();
	    for (int i=0;i<headPoints;i++)
	    {
	        double percentDone = ((double)i)/((double)headPoints);
	        double currentEllipseAngle = percentDone * 2 * Math.PI;
	           
	        Point newPoint = new Point();
	        newPoint.x = ORIGIN + (int) (headWidth/2 * Math.cos(currentEllipseAngle));
	        newPoint.y = ORIGIN + (int) (headHeight/2 * Math.sin(currentEllipseAngle));
	        
	        result.addPoint(newPoint.x, newPoint.y);
	    }
	    return result;
	}
}
