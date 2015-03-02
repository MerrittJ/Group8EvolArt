package Prototype;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ProtoGUIPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		int i = 0;	
		while (i<5){
			pc.calcNextPoints();
			g2d.drawLine(pc.getPreviousX(), pc.getPreviousY(), pc.getCurrentX(), pc.getCurrentY());
			g2d.drawLine(pc.getPreviousXm(), pc.getPreviousY(), pc.getCurrentXm(), pc.getCurrentY());
			pc.updatePrev();
			
			i++;
		}
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
