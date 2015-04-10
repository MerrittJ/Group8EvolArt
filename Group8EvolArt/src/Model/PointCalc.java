package Model;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Random;

import Stage2.DNA;
import Stage2.Pair;

/**
 * Class responsible for generating the points to be drawn by ProtoGUIPanel. Will interact with DNA objects in future to influence how/where lines are drawn.
 * @author Josh Merritt
 *
 */
public class PointCalc {

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
	private NoseCalc nc;

	/**
	 * Main drawing method
	 */
	public PointCalc(){
		 hc = new HeadCalc();
		 ec = new EyeCalc();
		 ebc = new EyebrowCalc();
		 nc = new NoseCalc();
	}

	public void supplyDNA(DNA dna){
		int[] headAttribs = dna.getHeadAttribs();
		int[] eyeAttribs = dna.getEyeAttribs();
		int[] eyebrowAttribs = dna.getEyebrowAttribs();
		int[] noseAttribs = dna.getNoseAttribs();
		
		hc.setAttribs(headAttribs);
		ec.setAttribs(eyeAttribs);
		ebc.setAttribs(eyebrowAttribs);
		nc.setAttribs(noseAttribs);
	}
	
	public Polygon getHeadShape(){
		return hc.getHeadShape();
	}
	
	public HashMap<Integer, Pair<Integer, Integer>> getNosePoints(){
		return nc.getNosePoints();
	}
	
	public int getHeadLines(){
		return hc.getHeadPoints();
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