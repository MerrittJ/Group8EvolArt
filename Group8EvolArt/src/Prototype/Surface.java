package Prototype;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Class responsible for generating the points and lines to be drawn by Drawer. Will accept DNA objects in future to influence how/where lines are drawn.
 * @author Josh Merritt
 *
 */
class Surface extends JPanel {
	
	/**
	 * Variable to dictate centre of drawing frame
	 */
	private static final int ORIGIN = 175;
    
	/**
	 * Main drawing method
	 * @param g - a Graphics object used for visuals in Java Swing
	 */
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // set initial point to draw from at centre of frame
        int previousFinishX = ORIGIN;
        int previousFinishY = ORIGIN;
        int previousFinishXm = ORIGIN;
        Random rnd = new Random();
        int nextX = ORIGIN; 
        int nextY = ORIGIN; 
        int nextXm = ORIGIN;
        
        // draws 10 lines, mirroring each one in the X axis to create symmetry
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
        	
        	i++;
        }

   } 

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}