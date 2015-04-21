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
	
	private HeadCalc hc;
	private EyeCalc ec;
	private EyebrowCalc ebc;
	private NoseCalc nc;
	private MouthCalc mc;
	private DNA dnaInUse;

	private int i;

	/**
	 * Main drawing method
	 * @param i 
	 * @param b 
	 * @param p 
	 */
	
	public PointCalc(int i, boolean b, int p){
		this.i=i;
		 hc = new HeadCalc(i,b,p);
		mc = new MouthCalc(i, b,p);
		ec = new EyeCalc(i,b,p);
		nc = new NoseCalc(i,b,p);
		ebc = new EyebrowCalc(i,b,p);
	}

	public void supplyDNA(DNA dna){
		int[] headAttribs = dna.getHeadAttribs();
		int[] eyeAttribs = dna.getEyeAttribs();
		int[] eyebrowAttribs = dna.getEyebrowAttribs();
		int[] noseAttribs = dna.getNoseAttribs();
		int[] mouthAttribs = dna.getMouthAttribs();
		dnaInUse = dna;
		
		hc.setAttribs(headAttribs);
		ec.setAttribs(eyeAttribs);
		ebc.setAttribs(eyebrowAttribs);
		nc.setAttribs(noseAttribs);
		mc.setAttribs(mouthAttribs);
	}
	
	public Polygon getHeadPoints(){

		return hc.getHeadShape();
	}
	
	public Pair<Polygon, Polygon> getAllEyePoints(){
		return ec.getAllEyePoints();
	}
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints() {
		return ebc.getEyebrowPoints();
	}
	
	public HashMap<Integer, Pair<Integer, Integer>> getNosePoints(){
		return nc.getNosePoints();
	}
	
	
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getMouthPoints(){
		return mc.getMouthPoints();
	}
	
	public String getDNAString(){
		return dnaInUse.toString();
	}
}
