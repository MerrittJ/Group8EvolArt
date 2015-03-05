package Stage2;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;

/**
 * Class responsible for generating the points to be drawn by ProtoGUIPanel. Will interact with DNA objects in future to influence how/where lines are drawn.
 * @author Josh Merritt
 *
 */
class PointCalc {

	/**
	 * Variable to dictate centre of drawing frame
	 */
	private static final int ORIGIN = 175;

	private int previousX;
	private int previousY;
	private int previousXm;
	private int currentX; 
	private int currentY; 
	private int currentXm;
	
	private HeadCalc hc;
	private EyeCalc ec;
	private EyebrowCalc ebc;

	/**
	 * Main drawing method
	 */
	public PointCalc(){
		// set initial point to draw from at centre of frame
		resetToOrigin();
	}

	public void supplyDNA(String[] dna){
		String[] headAttribs = new String[3];
		System.arraycopy(dna, 0, headAttribs, 0, 3);
		
		String[] eyeAttribs = new String[3];
		System.arraycopy(dna, 3, eyeAttribs, 0, 2);
		
		String[] eyebrowAttribs = new String[3];
		System.arraycopy(dna, 5, eyebrowAttribs, 0, 2);
		
		hc.setAttribs(headAttribs);
		ec.setAttribs(eyeAttribs);
		ebc.setAttribs(eyebrowAttribs);
	}
	
	public HashMap<Integer, Pair<Integer, Integer>> getHeadShapePoints(){
		//new array holding the points required to draw (a side of) the head
		HashMap<Integer, Pair<Integer, Integer>> points = new HashMap<Integer, Pair<Integer, Integer>>(hc.getHeadLines()+1);
		//mirrored side
		HashMap<Integer, Pair<Integer, Integer>> pointsM = new HashMap<Integer, Pair<Integer, Integer>>(hc.getHeadLines()+1);
		
		Pair<Integer, Integer> hold = new Pair<Integer, Integer>();
		int hw = hc.getHeadWidth();
		int hh = hc.getHeadHeight();
		int hl = hc.getHeadLines();
		int propX = (hw / 2) / (hl / 2);
		int propY = (hh / 2) / (hl / 2);
		
		//top
		hold.x = 0;
		hold.y = ORIGIN + (hh / 2);
		points.put(0, hold);
		
		int i = 1;
		while (i < ((hl / 2) + 1)) {
			hold.x = ORIGIN + propX * i;
			hold.y = ORIGIN - propY * i;
			points.put(i, hold);
			i++;
		}
		
		while (i < ((hl) + 1)) {
			hold.x = ORIGIN - propX * i;
			hold.y = ORIGIN - propY * i;
			points.put(i, hold);
		}
		
		
		
		//bottom
		hold.x = 0;
		hold.y = ORIGIN - (hc.getHeadHeight() / 2);
		points.put(2, hold);
		
		//width (left or right?), mirrored regardless
		points[2] = ORIGIN + (hc.getHeadWidth() / 2);
		points[3] = points[0] 
		return points;
	}
	
	public void calcNextPoints() {
		calcNextX();
		calcNextY();
		calcNextXm();
	} 

	public void calcNextX(){
		
		Random rnd = new Random();
		currentX = rnd.nextInt(currentX+50);
	}
	
	public void calcNextY(){
		
		Random rnd = new Random();
		currentY = rnd.nextInt(currentY+50);
	}
	
	public void calcNextXm(){
		
		if (currentX > ORIGIN) {
			currentXm = ORIGIN - Math.abs(ORIGIN - currentX);
		}
		else if (currentX < ORIGIN) {
			currentXm = ORIGIN + Math.abs(ORIGIN - currentX);
		}
		else if (currentX == ORIGIN) {
			currentXm = currentX;
		}  
	}
	
	public void updatePrev(){
		previousX = currentX;
		previousY = currentY;
		previousXm = currentXm;
	}
	
	public void resetToOrigin() {
		previousX = ORIGIN;
		previousY = ORIGIN;
		previousXm = ORIGIN;

		currentX = ORIGIN; 
		currentY = ORIGIN; 
		currentXm = ORIGIN;
	}

	public int getCurrentX() {
		return currentX;
	}    

	public int getCurrentY() {
		return currentY;
	}

	public int getCurrentXm() {
		return currentXm;
	}

	public int getPreviousX() {
		return previousX;
	}    

	public int getPreviousY() {
		return previousY;
	}

	public int getPreviousXm() {
		return previousXm;
	}

}