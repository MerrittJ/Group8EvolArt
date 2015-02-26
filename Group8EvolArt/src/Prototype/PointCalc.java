package Prototype;
import java.util.Random;

/**
 * Class responsible for generating the points and lines to be drawn by Drawer. Will accept DNA objects in future to influence how/where lines are drawn.
 * @author Josh Merritt
 *
 */
class PointCalc {

	/**
	 * Variable to dictate centre of drawing frame
	 */
	private static final int ORIGIN = 175;

	private int previousFinishX;
	private int previousFinishY;
	private int previousFinishXm;
	private int nextX; 
	private int nextY; 
	private int nextXm;
	private Random rnd;

	/**
	 * Main drawing method
	 * @param g - a Graphics object used for visuals in Java Swing
	 */
	public PointCalc(){
		// set initial point to draw from at centre of frame
		previousFinishX = ORIGIN;
		previousFinishY = ORIGIN;
		previousFinishXm = ORIGIN;

		nextX = ORIGIN; 
		nextY = ORIGIN; 
		nextXm = ORIGIN;
	}

	public void calcNextPoints(int prevX, int prevY) {
		//updatePrev();
		calcNextX(prevX);
		calcNextY(prevY);
		calcNextXm(prevX);
		
	} 

	public void calcNextX(int prevX){
		
		Random rnd = new Random();
		nextX = rnd.nextInt(previousFinishX+50);
		previousFinishX = prevX;
	}
	
	public void calcNextY(int prevY){
		
		Random rnd = new Random();
		nextY = rnd.nextInt(previousFinishY+50);
		previousFinishY = prevY;
	}
	
	public void calcNextXm(int prevX){
		
		if (nextX > ORIGIN) {
			nextXm = ORIGIN - Math.abs(ORIGIN - nextX);
		}
		else if (nextX < ORIGIN) {
			nextXm = ORIGIN + Math.abs(ORIGIN - nextX);
		}
		else if (nextX == ORIGIN) {
			nextXm = nextX;
		}  
		previousFinishXm = prevX;
	}
	
	public void updatePrev(){
		previousFinishX = nextX;
		previousFinishY = nextY;
		previousFinishXm = nextXm;
	}

	public int getNextX() {
		return nextX;
	}    

	public int getNextY() {
		return nextY;
	}

	public int getNextXm() {
		return nextXm;
	}

	public int getPreviousFinishX() {
		return previousFinishX;
	}    

	public int getPreviousFinishY() {
		return previousFinishY;
	}

	public int getPreviousFinishXm() {
		return previousFinishXm;
	}

}