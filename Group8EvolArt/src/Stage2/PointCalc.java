package Stage2;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
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
	private static final int ORIGIN = 175*2;

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
		 hc = new HeadCalc();
		 ec = new EyeCalc();
		 ebc = new EyebrowCalc();
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
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getHeadShapePointsOld(){
		return hc.getHeadShapePointsOld();
	}
	
	public Ellipse2D getHeadShape(){
		return hc.getHeadShape();
	}
	
	public int getHeadLines(){
		return hc.getHeadLines();
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

	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints() {
		return ebc.getEyebrowPoints();
	}
	
	public Pair<Polygon, Polygon> getAllEyePoints(){
		return ec.getAllEyePoints();
	}

}