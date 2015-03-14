package Model;

import java.awt.Polygon; //has contains() method, helpful for boundary checks!

import Stage2.Pair;

public class EyeCalc {

	private int ORIGIN = 350;
	private int eyeWidth;
	private int eyeHeight;
	private int eyePoints = 30;
	//private int eyeRadius;
	//private int xDistance;

	public EyeCalc() {

	}

	public void setAttribs(String[] attribs){
		eyeWidth = (Integer.parseInt(attribs[0]));
		eyeHeight = Integer.parseInt(attribs[1]);
	}

	public int getEyeWidth() {
		return eyeWidth;
	}

	public int getEyeHeight() {
		return eyeHeight;
	}

	public int getEyePoints() {
		return eyePoints;
	}

	public Pair<Polygon, Polygon> getAllEyePoints(){

		Polygon p = new Polygon();
		for (int i = 0; i < eyePoints; i++){
			p.addPoint((int) (ORIGIN + /*xDistance*/50 + /*eyeRadius*/50 * Math.cos(/*rotation? x * */i * 2 * Math.PI / eyePoints)), (int) (ORIGIN + /*eyeRadius*/50 * Math.sin(/*rotation? x * */i * 2 * Math.PI / eyePoints)));
		}
		
		Polygon p2 = new Polygon();
		for (int i = 0; i < eyePoints; i++){
			p2.addPoint((int) (ORIGIN - /*xDistance*/50 + /*eyeRadius*/50 * Math.cos(i * 2 * Math.PI / eyePoints)), (int) (ORIGIN + /*eyeRadius*/50 * Math.sin(i * 2 * Math.PI / eyePoints)));
		}
		
		Pair<Polygon, Polygon> pair = new Pair<Polygon, Polygon>();
		pair.x = p;
		pair.y = p2;
		return pair;
	}
}