package Model;

import java.util.HashMap;

import Stage2.Pair;

public class MouthCalc extends AbstractCalc{

	private int mouthMidWidth;// = 50;
	private int mouthSideWidth; // = 50;
	private int mouthHeight;// = 50; //positive smile, negative frown
	
	public MouthCalc(){
		
	}
	
	public void setAttribs(int[] attribs){
		mouthMidWidth = attribs[0];
		mouthSideWidth = attribs[1];
		mouthHeight = attribs[2];
	}
	
	public int getMouthMidWidth() {
		return mouthMidWidth;
	}

	public int getMouthSideWidth() {
		return mouthSideWidth;
	}

	public int getMouthHeight() {
		return mouthHeight;
	}
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getMouthPoints(){
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allPoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();
		
		HashMap<Integer, Pair<Integer, Integer>> right = new HashMap<Integer, Pair<Integer, Integer>>();
		HashMap<Integer, Pair<Integer, Integer>> left = new HashMap<Integer, Pair<Integer, Integer>>();
		
		//draw right mid + side
		Pair<Integer, Integer> r1 = new Pair<Integer, Integer>();
		
		r1.x = ORIGIN;
		r1.y = ORIGIN + 100; //some starting point???
		right.put(0, r1);
		
		Pair<Integer, Integer> r2 = new Pair<Integer, Integer>();
		r2.x = r1.x + mouthMidWidth/2;
		r2.y = r1.y;
		right.put(1, r2);
		
		Pair<Integer, Integer> r3 = new Pair<Integer, Integer>();
		r3.x = r2.x + mouthSideWidth;
		r3.y = r1.y - mouthHeight;
		right.put(2, r3);
		
		//draw left mid + side
		Pair<Integer, Integer> l1 = new Pair<Integer, Integer>();
		
		l1.x = ORIGIN;
		l1.y = ORIGIN + 100; //some starting point???
		left.put(0, l1);
		
		Pair<Integer, Integer> l2 = new Pair<Integer, Integer>();
		l2.x = l1.x - mouthMidWidth/2;
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
