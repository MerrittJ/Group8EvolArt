package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashMap;

import javax.swing.JPanel;

import Model.PointCalc;
/**
 * JPanel on which a biomorph/face is drawn onto using Graphics2D.
 * @author Josh Merritt
 */
public class BiomorphPanel extends JPanel {

	PointCalc pc;
	/**
	 * Mutation integer passed to calculators further down hierarchy
	 */
	public int i;

	/**
	 * Constructor for BiomorphPanel. Takes parameters responsible for mutation. Created by Sheraz Atiq and Aman Kauldhar.
	 * @param i Integer that ensures each biomorph in the generation created for the GUI is different from one another
	 * @param b Boolean that determines whether or not results should be different from input. This is linked with usage in the Hall of Fame and other 'cloning' situations of the biomorph
	 * @param p Integer stemming from which biomorph was selected in the generation. Key part of the 'mutation' process.
	 */
	public BiomorphPanel(int i, boolean b, int p) {
		this.i = i;
		pc = new PointCalc(i, b, p);
	}

	/**
	 * Drawing method called on instantiation of Panel. Draws each facial feature according to points received from calculators.
	 */
	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		// draw head
		Polygon hPoints = pc.getHeadPoints();
		g2d.drawPolygon(hPoints);

		// draw eyes
		Pair<Polygon, Polygon> ePoints = pc.getAllEyePoints();
		g2d.drawPolygon(ePoints.x);
		g2d.drawPolygon(ePoints.y);

		// draw eyebrows
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> ebPoints = pc.getEyebrowPoints();
		g2d.drawLine(ebPoints.x.get(0).x, ebPoints.x.get(0).y, ebPoints.x.get(1).x, ebPoints.x.get(1).y);
		g2d.drawLine(ebPoints.y.get(0).x, ebPoints.y.get(0).y, ebPoints.y.get(1).x, ebPoints.y.get(1).y);

		// draw nose
		HashMap<Integer, Pair<Integer, Integer>> nPoints = pc.getNosePoints();
		g2d.drawLine(nPoints.get(0).x, nPoints.get(0).y, nPoints.get(1).x, nPoints.get(1).y);
		g2d.drawLine(nPoints.get(1).x, nPoints.get(1).y, nPoints.get(2).x, nPoints.get(2).y);

		// draw mouth
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> mPoints = pc .getMouthPoints();
		g2d.drawLine(mPoints.x.get(0).x, mPoints.x.get(0).y, mPoints.x.get(1).x, mPoints.x.get(1).y);
		g2d.drawLine(mPoints.x.get(1).x, mPoints.x.get(1).y, mPoints.x.get(2).x, mPoints.x.get(2).y);

		g2d.drawLine(mPoints.y.get(0).x, mPoints.y.get(0).y, mPoints.y.get(1).x, mPoints.y.get(1).y);
		g2d.drawLine(mPoints.y.get(1).x, mPoints.y.get(1).y, mPoints.y.get(2).x, mPoints.y.get(2).y);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// scaling and translating to fit into mini panels in GUI
		g2.scale(0.15, 0.15);
		g2.translate(-100.0, 0.0);
		super.paintComponent(g2);
		doDrawing(g2);
	}

}
