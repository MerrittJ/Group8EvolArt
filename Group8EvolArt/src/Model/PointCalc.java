package Model;
import java.awt.Polygon;
import java.util.HashMap;
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
	
	private HeadCalc hc;
	private EyeCalc ec;
	private EyebrowCalc ebc;
	private NoseCalc nc;
	private MouthCalc mc;

	/**
	 * Main drawing method
	 */
	
	public PointCalc(){
		 hc = new HeadCalc();
		 ec = new EyeCalc();
		 ebc = new EyebrowCalc();
		 nc = new NoseCalc();
		 mc = new MouthCalc();
	}

	public void supplyDNA(DNA dna){
		int[] headAttribs = dna.getHeadAttribs();
		int[] eyeAttribs = dna.getEyeAttribs();
		int[] eyebrowAttribs = dna.getEyebrowAttribs();
		int[] noseAttribs = dna.getNoseAttribs();
		int[] mouthAttribs = dna.getMouthAttribs();
		
		hc.setAttribs(headAttribs);
		ec.setAttribs(eyeAttribs);
		ebc.setAttribs(eyebrowAttribs);
		nc.setAttribs(noseAttribs);
		mc.setAttribs(mouthAttribs);
	}
	
	public Polygon getHeadPoints(){
		//not headPoints due to that being an attrib!!!
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
}
