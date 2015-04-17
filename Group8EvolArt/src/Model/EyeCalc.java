package Model;

import java.awt.Point;
import java.awt.Polygon; //has contains() method, helpful for boundary checks!

import Stage2.Pair;

public class EyeCalc extends AbstractCalc {

	private int eyeWidth; //= 95;
	private int eyeHeight; //= 50;
	private int eyePoints;// = 8;
	//private int eyeRadius;
	private int xDistance;// = 100;

	public EyeCalc() {

	}

	public void setAttribs(int[] attribs){
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
	
	public Pair<Polygon, Polygon> getAllEyePoints()
	{
		Pair<Polygon, Polygon> result = new Pair<Polygon, Polygon>();
		
	    Polygon eye1 = new Polygon();
	    for (int i=0;i<eyePoints;i++)
	    {
	        double percentDone = ((double)i)/((double)eyePoints);
	        double currentEllipseAngle = percentDone * 2 * Math.PI;
	        
	        Point newPoint = new Point();
	        newPoint.x = ORIGIN + (xDistance/2) + (int) (eyeWidth/2 * Math.cos(currentEllipseAngle));
	        newPoint.y = ORIGIN + (int) (eyeHeight/2 * Math.sin(currentEllipseAngle));   
	        
	        eye1.addPoint(newPoint.x, newPoint.y);
	    }
	    
	    Polygon eye2 = new Polygon();
	    for (int i=0;i<eyePoints;i++)
	    {
	        double percentDone = ((double)i)/((double)eyePoints);
	        double currentEllipseAngle = percentDone * 2 * Math.PI;
	        
	        Point newPoint = new Point();
	        newPoint.x = ORIGIN -(xDistance/2) + (int) (eyeWidth/2 * Math.cos(currentEllipseAngle));
	        newPoint.y = ORIGIN + (int) (eyeHeight/2 * Math.sin(currentEllipseAngle));   
	        
	        eye2.addPoint(newPoint.x, newPoint.y);
	    }
	    
	    result.x = eye1;
	    result.y = eye2;
	    return result;
	}
}
