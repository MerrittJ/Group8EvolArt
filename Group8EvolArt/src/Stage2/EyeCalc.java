package Stage2;

import java.awt.Polygon;

public class EyeCalc {

	private int ORIGIN = 350;
	private int eyeWidth;
	private int eyeHeight;
	private int eyePoints;

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
			p.addPoint((int) (ORIGIN + 50 + 50 * Math.cos(60 + i * 2 * Math.PI / 5)), (int) (ORIGIN + 50 * Math.sin(60 + i * 2 * Math.PI / 5)));
		}
		
		Polygon p2 = new Polygon();
		for (int i = 0; i < eyePoints; i++){
			p2.addPoint((int) (ORIGIN - 50 + 50 * Math.cos(60 + i * 2 * Math.PI / 5)), (int) (ORIGIN + 50 * Math.sin(60 + i * 2 * Math.PI / 5)));
		}
		
		Pair<Polygon, Polygon> pair = new Pair<Polygon, Polygon>();
		pair.x = p;
		pair.y = p2;
		return pair;
	}
}