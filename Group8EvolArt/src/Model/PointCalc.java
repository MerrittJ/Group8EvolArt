package Model;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Random;

import Stage2.DNA;
import Stage2.Pair;

/**
 * Class responsible for passing the generated points to a BiomorphPanel. Contains calculators for each facial feature.
 * @author Josh Merritt
 *
 */
public class PointCalc {
	
	private HeadCalc hc;
	private EyeCalc ec;
	private EyebrowCalc ebc;
	private NoseCalc nc;
	private MouthCalc mc;

	/**
	 * Mutation integer passed down hierarchy to calculators
	 */
	private int i;

	/**
	 * Constructor for PointCalc. Takes parameters passed down from BiomorphPanel to be used in mutation/generation of images. Created by Sheraz Atiq and Aman Kauldhar.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public PointCalc(int i, boolean b, int p){
		this.i=i;
		 hc = new HeadCalc(i,b,p);
		mc = new MouthCalc(i,b,p);
		ec = new EyeCalc(i,b,p);
		nc = new NoseCalc(i,b,p);
		ebc = new EyebrowCalc(i,b,p);
	}
	
	/**
	 * Getter method for head points
	 */
	public Polygon getHeadPoints(){
		//not headPoints due to that being an attrib!!!
		return hc.getHeadShape();
	}
	
	/**
	 * Getter method for eye points
	 */
	public Pair<Polygon, Polygon> getAllEyePoints(){
		return ec.getAllEyePoints();
	}
	
	/**
	 * Getter method for eyebrow points
	 */
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getEyebrowPoints() {
		return ebc.getEyebrowPoints();
	}
	
	/**
	 * Getter method for nose points
	 */
	public HashMap<Integer, Pair<Integer, Integer>> getNosePoints(){
		return nc.getNosePoints();
	}
	
	/**
	 * Getter method for mouth points
	 */
	public Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> getMouthPoints(){
		return mc.getMouthPoints();
	}
}