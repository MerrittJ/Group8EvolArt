package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JPanel;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
//		//draw head
//		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> points = pc.getHeadShapePoints();
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
		
		//draw eyebrows
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> points = pc.getEyebrowPoints();
		int i = 1;
		while (i < points.x.size()){
			g2d.drawLine(points.x.get(i-1).x, points.x.get(i-1).y, points.x.get(i).x, points.x.get(i).y);
			i++;
		}
		
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
