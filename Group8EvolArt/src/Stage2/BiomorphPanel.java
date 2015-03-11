package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JPanel;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		int i = 1;	
//		while (i<5){
//			pc.calcNextPoints();
//			g2d.drawLine(pc.getPreviousX(), pc.getPreviousY(), pc.getCurrentX(), pc.getCurrentY());
//			g2d.drawLine(pc.getPreviousXm(), pc.getPreviousY(), pc.getCurrentXm(), pc.getCurrentY());
//			pc.updatePrev();
//			
//			i++;
//		}
//		pc.resetToOrigin();
		
		//draw head
		Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> points = pc.getHeadShapePoints();
		while (i < 4) {
			//g2d.drawLine(points.x.get(i).x, points.x.get(i).y, points.y.get(i).x, points.y.get(i).y);
			g2d.drawLine(points.x.get(i).x, points.x.get(i).y, 10, 10);
			i++;
		}
		
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
