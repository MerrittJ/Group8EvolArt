package Model;

import java.util.HashMap;

import Stage2.Pair;

public class NoseCalc {

	private int yOffset;// = -100; //reference from bottom of nose
	private int noseLength;// = 20; //negative number to switch nose direction?
	private int noseRise;// = 10; //how 'upturned' the nose is
	private int noseHeight ;//= 80; //height of nose from top to bottom

	private int ORIGIN = 350;
	
	public NoseCalc(){
		
	}
	
	public void setAttribs(int[] attribs){
		yOffset = attribs[0];
		noseLength = attribs[1];
		noseRise = attribs[2];
		noseHeight = attribs[3];
	}

	public int getyOffset() {
		return yOffset;
	}

	public int getNoseLength() {
		return noseLength;
	}

	public int getNoseRise() {
		return noseRise;
	}

	public HashMap<Integer, Pair<Integer, Integer>> getNosePoints(){
		
		HashMap<Integer, Pair<Integer, Integer>> points = new HashMap<Integer, Pair<Integer, Integer>>();
		
		points.put(0, new Pair<Integer, Integer>(ORIGIN, (ORIGIN - yOffset - noseHeight))); //top of nose
		points.put(1, new Pair<Integer, Integer>((ORIGIN - noseLength), (ORIGIN - yOffset - noseRise))); //tip of nose
		points.put(2, new Pair<Integer, Integer>(ORIGIN, (ORIGIN - yOffset))); //bottom of nose
		
		return points;
	}
	
}
