package Model;

import java.util.HashMap;

import Stage2.Pair;

public class NoseCalc extends AbstractCalc{

	private int yOffset;// = -100; //reference from bottom of nose
	private int noseLength;// = 20; //negative number to switch nose direction?
	private int noseRise;// = 10; //how 'upturned' the nose is
	private int noseHeight ;//= 80; //height of nose from top to bottom

	public NoseCalc(int i, boolean b, int p) {
		if (b) {
			if (p == 1 || p==6 || p==5) {
				if (i == 3) {
					this.noseHeight = 75;
				}
				if (i == 6) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 7) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}
			if (p == 3 || p==9 || p==7) {
				if (i == 1) {
					this.noseHeight = 75;
				}
				if (i == 5) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 2) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}
			if (p == 2 || p==8) {
				if (i == 3) {
					this.noseHeight = 75;
				}
				if (i ==6) {
					this.noseHeight = 90;
					this.noseLength = 22;
				}
				if (i == 7) {
					this.noseHeight = 60;
					this.noseLength = 18;
				}
			}

		}
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
