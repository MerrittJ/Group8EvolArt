package Prototype;
import java.util.Random;

/**
 * Class responsible for generating the points to be drawn by ProtoGUIPanel. Will interact with DNA objects in future to influence how/where lines are drawn.
 * @author Josh Merritt
 *
 */
class ProtoPointCalc {

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

	/**
	 * Main drawing method
	 */
	public ProtoPointCalc(){
		// set initial point to draw from at centre of frame
		resetToOrigin();
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