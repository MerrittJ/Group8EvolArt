package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import javax.swing.JPanel;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
//		//draw headOld
//		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> points = pc.getHeadShapePointsOld();
//		int i = 1;
//		while (i < 4) {
//			g2d.drawLine(points.x.get(i-1).x, points.x.get(i-1).y, points.x.get(i).x, points.x.get(i).y);
//			i++;
//		}
//		
//		i = 1;
//		while (i < 4) {
//			g2d.drawLine(points.y.get(i-1).x, points.y.get(i-1).y, points.y.get(i).x, points.y.get(i).y);
//			i++;
//		}
		
		//draw head
		Ellipse2D hPoints = pc.getHeadShape();
		g2d.draw(hPoints);
		
		//draw eyebrows
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> ebPoints = pc.getEyebrowPoints();
		g2d.drawLine(ebPoints.x.get(0).x, ebPoints.x.get(0).y, ebPoints.x.get(1).x, ebPoints.x.get(1).y);
		g2d.drawLine(ebPoints.y.get(0).x, ebPoints.y.get(0).y, ebPoints.y.get(1).x, ebPoints.y.get(1).y);
		
		//draw eyes
		Pair<Polygon, Polygon> ePoints = pc.getAllEyePoints();
		g2d.drawPolygon(ePoints.x);
		g2d.drawPolygon(ePoints.y);
		
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
