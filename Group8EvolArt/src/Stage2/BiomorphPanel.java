package Stage2;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
//		int i = 0;	
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
		g2d.drawLine();
		
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
