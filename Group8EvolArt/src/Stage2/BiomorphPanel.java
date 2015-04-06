package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import javax.swing.JPanel;

import Model.PointCalc;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		//draw head
		Polygon hPoints = pc.getHeadShape();
		g2d.drawPolygon(hPoints);
		
		//draw eyebrows
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> ebPoints = pc.getEyebrowPoints();
		g2d.drawLine(ebPoints.x.get(0).x, ebPoints.x.get(0).y, ebPoints.x.get(1).x, ebPoints.x.get(1).y);
		g2d.drawLine(ebPoints.y.get(0).x, ebPoints.y.get(0).y, ebPoints.y.get(1).x, ebPoints.y.get(1).y);
		
		//draw eyes
		Pair<Polygon, Polygon> ePoints = pc.getAllEyePoints();
		g2d.drawPolygon(ePoints.x);
		g2d.drawPolygon(ePoints.y);
		
		//draw nose
		HashMap<Integer, Pair<Integer, Integer>> nPoints = pc.getNosePoints();
		g2d.drawLine(nPoints.get(0).x, nPoints.get(0).y, nPoints.get(1).x, nPoints.get(1).y);
		g2d.drawLine(nPoints.get(1).x, nPoints.get(1).y, nPoints.get(2).x, nPoints.get(2).y);
	}
	
	 @Override
	 public void paintComponent(Graphics g) {       
		 Graphics2D g2 = (Graphics2D) g;
		 //scaling and translating to fit into mini panels in GUI
		 g2.scale(0.15, 0.15);
		 g2.translate(-100.0, 0.0);
		 super.paintComponent(g2);
	     doDrawing(g2);
	    }    

}
