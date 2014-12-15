import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

class Surface extends JPanel {
	
	private int ORIGIN = 175;
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int previousFinishX = ORIGIN;
        int previousFinishY = ORIGIN;
        int previousFinishXm = ORIGIN;
        Random rnd = new Random();
        int nextX = ORIGIN; //rnd.nextInt(previousFinishX+50);
        int nextY = ORIGIN; //rnd.nextInt(previousFinishY+50);
        int nextXm = ORIGIN;
        
        int i = 0;
        while (i<10){

        	previousFinishX = nextX;
        	previousFinishY = nextY;
        	nextX = rnd.nextInt(previousFinishX+50);
        	nextY = rnd.nextInt(previousFinishY+50);
        	g2d.drawLine(previousFinishX, previousFinishY, nextX, nextY);
        	
        	if (nextX > ORIGIN) {
        		nextXm = ORIGIN - Math.abs(ORIGIN - nextX);
        	}
        	else if (nextX < ORIGIN) {
        		nextXm = ORIGIN + Math.abs(ORIGIN - nextX);
        	}
        	else if (nextX == ORIGIN) {
        		nextXm = nextX;
        	}
        	
        	g2d.drawLine(previousFinishXm, previousFinishY, nextXm, nextY);
        	previousFinishXm = nextXm;
        	// = -(rnd.nextInt(previousFinishX+50) + ORIGIN);
        	
        	i++;
        }

   } 

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}