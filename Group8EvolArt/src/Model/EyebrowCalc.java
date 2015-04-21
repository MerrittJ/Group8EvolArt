package Model;

import java.util.HashMap;

import Stage2.Pair;

public class EyebrowCalc extends AbstractCalc {

	private int eyebrowWidth; //= 100;
	private int eyebrowHeight; // = 50;
	//private int eyebrowLines = 6; //non-functional at this time
	private int eyebrowDistance; // = 100;
	
	public EyebrowCalc(int i, boolean b, int p) {
		if (b) {
			if (p == 1 || p==7 || p==9) {
				if (i == 3) {
					this.eyebrowHeight = 75;
				}
				if (i == 6) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 150;
				}
				if (i == 7) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 50;
				}
			}
			if (p == 3 || p==8 || p==5) {
				if (i == 1) {
					this.eyebrowHeight = 75;
				}
				if (i == 5) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 75;
				}
				if (i == 2) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 80;
				}
			}
			if (p == 2 || p==6) {
				if (i == 3) {
					this.eyebrowHeight = 75;
				}
				if (i ==6) {
					this.eyebrowHeight = 90;
					this.eyebrowWidth = 50;
				}
				if (i == 7) {
					this.eyebrowHeight = 60;
					this.eyebrowWidth = 40;
				}
			}

		}else{
			if (i == 3) {
				this.eyebrowHeight = 75;
			}
			if (i ==6) {
				this.eyebrowHeight = 90;
				this.eyebrowWidth = 50;
			}
			if (i == 7) {
				this.eyebrowHeight = 60;
				this.eyebrowWidth = 40;
			}
		}
		
	}
	
	public void setAttribs(int[] attribs){
		eyebrowWidth = attribs[0];
		eyebrowHeight = attribs[1];
		eyebrowDistance = attribs[2];
		
	}
	
	public int getEyebrowWidth() {
		return eyebrowWidth;
	}
	
	public int getEyebrowHeight() {
		return eyebrowHeight;
	}
	
	public int getEyebrowDistance() {
		return eyebrowDistance;
	}
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints(){
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allpoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();
		
		HashMap<Integer, Pair<Integer, Integer>> eyebrow = new HashMap<Integer, Pair<Integer, Integer>>();
		HashMap<Integer, Pair<Integer, Integer>> eyebrowM = new HashMap<Integer, Pair<Integer, Integer>>();
		
		//draw right eyebrow (2 points)
		Pair<Integer, Integer> ebr = new Pair<Integer, Integer>();
		ebr.x = ORIGIN + (eyebrowDistance / 2);
		ebr.y = ORIGIN - 100; //some starting point???
		eyebrow.put(0, ebr);
		
		Pair<Integer, Integer> ebr2 = new Pair<Integer, Integer>();
		ebr2.x = ebr.x + eyebrowWidth;
		ebr2.y = ebr.y - eyebrowHeight;
		eyebrow.put(1, ebr2);
		
		//draw left (2 points)
		Pair<Integer, Integer> ebl = new Pair<Integer, Integer>();
		ebl.x = ORIGIN - (eyebrowDistance / 2);
		ebl.y = ebr.y;
		eyebrowM.put(0, ebl);
		
		Pair<Integer, Integer> ebl2 = new Pair<Integer, Integer>();
		ebl2.x = ebl.x - eyebrowWidth;
		ebl2.y = ebl.y - eyebrowHeight;
		eyebrowM.put(1, ebl2);

		
		allpoints.x = eyebrow;
		allpoints.y = eyebrowM;
		return allpoints;
	}
}
