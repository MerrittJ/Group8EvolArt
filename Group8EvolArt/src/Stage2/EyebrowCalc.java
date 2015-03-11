package Stage2;

import java.util.HashMap;

public class EyebrowCalc {

	private int eyebrowWidth = 100;
	private int eyebrowHeight = 100;
	private int eyebrowLines = 6;
	private int eyebrowDistance;
	
	public EyebrowCalc() {
		
	}
	
	public void setAttribs(String[] attribs){
		eyebrowWidth = Integer.parseInt(attribs[0]);
		eyebrowHeight = Integer.parseInt(attribs[1]);
		eyebrowLines = Integer.parseInt(attribs[2]);
	}
	
	public int getEyebrowWidth() {
		return eyebrowWidth;
	}
	
	public int getEyebrowHeight() {
		return eyebrowHeight;
	}
	
	public int getEyebrowLines() {
		return eyebrowLines;
	}
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints(){
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> allpoints = new Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>>();
		
		HashMap<Integer, Pair<Integer, Integer>> eyebrow = new HashMap<Integer, Pair<Integer, Integer>>();
		HashMap<Integer, Pair<Integer, Integer>> eyebrowM = new HashMap<Integer, Pair<Integer, Integer>>();
		
		int i = 0;
		while (i < eyebrowLines){
			Pair<Integer, Integer> hold = new Pair<Integer, Integer>();
			hold.x = i*(eyebrowWidth / eyebrowLines);
			hold.y = 0;
			eyebrow.put(i, hold);
			i++;
			//mismatch between points and width, unsure how to resolve
		}
		
		i = 0;
		for (Pair<Integer, Integer> value : eyebrow.values()){
			if (i < (eyebrowLines/2)) {
				value.y = i*(eyebrowHeight / eyebrowLines);
			}
			else if (i == (eyebrowLines/2)){
				value.y = eyebrowHeight;
			}
			else if (i > (eyebrowLines/2)) {
				value.y = eyebrowHeight - (i*(eyebrowHeight / eyebrowLines));
			}
			i++;
		}
		
		allpoints.x = eyebrow;
		allpoints.y = eyebrowM;
		return allpoints;
	}
}