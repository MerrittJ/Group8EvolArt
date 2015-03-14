package Model;

import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import Stage2.Pair;

public class HeadCalc {

	private int ORIGIN = 350;
	private int headLines;
	private int headWidth = 500;
	private int headHeight = 500;
	
	public HeadCalc() {
		
	}
	
	public void setAttribs(String[] attribs){
		headLines = Integer.parseInt(attribs[0]);
		headWidth = Integer.parseInt(attribs[1]);
		headHeight = Integer.parseInt(attribs[2]);
	}
	
	public int getHeadLines() {
		return headLines;
	}
	
	public int getHeadWidth() {
		return headWidth;
	}
	
	public int getHeadHeight() {
		return headHeight;
	}
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getHeadShapePointsOld(){
		//see http://stackoverflow.com/questions/22694850/approximating-an-ellipse-with-a-polygon
		
		int ORIGIN = 350;
		//new array holding the points required to draw (a side of) the head
		HashMap<Integer, Pair<Integer, Integer>> points = new HashMap<Integer, Pair<Integer, Integer>>(getHeadLines()+1);
		//mirrored side
		HashMap<Integer, Pair<Integer, Integer>> pointsM = new HashMap<Integer, Pair<Integer, Integer>>(getHeadLines()+1);
		
		int hw = 200; //hc.getHeadWidth();
		int hh = 200; //hc.getHeadHeight();
		int hl = 8; //hc.getHeadLines();
		int propX = (hw / 4) / (hl / 2);
		int propY = (hh / 4) / (hl / 2);
		
		int i = 0;
		while (i < (hl / 2)) {
			Pair<Integer, Integer> hold = new Pair<Integer, Integer>();
			hold.x = ORIGIN + (propX * i);
			hold.y = ORIGIN + (hh / 2) - (propY * i);
			points.put(i, hold);
			hold.x = ORIGIN - (propX * i);
			pointsM.put(i, hold);
			i++;
		}
		
		while (i < hl) {
			Pair<Integer, Integer> hold = new Pair<Integer, Integer>();
			hold.x = (hw/2) - (propX * i);
			hold.y = ORIGIN - (hh / 2) - (propY * i);
			points.put(i, hold);
			hold.x = (ORIGIN - (hw/2)) + (propX * i);
			pointsM.put(i, hold);
			i++;
		}
		
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allPoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();
		allPoints.x = points;
		allPoints.y = pointsM;
		
		return allPoints;
	}
	
	public Ellipse2D getHeadShape(){
		Ellipse2D elip = new Ellipse2D.Double();
		elip.setFrameFromCenter(ORIGIN, ORIGIN, (ORIGIN - (headWidth/2)), (ORIGIN - (headHeight/2)));
		return elip;
	}
}
