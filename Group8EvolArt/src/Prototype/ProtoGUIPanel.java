package Prototype;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ProtoGUIPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		int i = 0;
		
		do{
			//pc.updatePrev();
			pc.calcNextPoints(pc.getPreviousFinishX(), pc.getPreviousFinishY());
			g2d.drawLine(pc.getPreviousFinishX(), pc.getPreviousFinishY(), pc.getNextX(), pc.getNextY());
			g2d.drawLine(pc.getPreviousFinishXm(), pc.getPreviousFinishY(), pc.getNextXm(), pc.getNextY());
			
			i++;
		}while (i<5);
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }    

}
