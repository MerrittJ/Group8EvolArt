package Stage2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.PointCalc;

public class BiomorphPanel extends JPanel{
	
	PointCalc pc = new PointCalc();
	DNAFactory d = new DNAFactory();
	private JLabel label = new JLabel();
	private Icon icon;
	private Graphics2D g2d;
	
	public JLabel getLabel() {
		return label;
	}

	public BiomorphPanel(){
		this.add(label);
	}
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		//g2d.scale(0.1, 0.1);
		drawAll(g2d, 1, 1);
		this.g2d = g2d;
	}
	
	 @Override
	 public void paintComponent(Graphics g) {       
		 Graphics2D g2 = (Graphics2D) g;
		 //scaling and translating to fit into mini panels in GUI
		 g2.scale(0.15, 0.15);
		// g2.translate(-150.0, -100.0);
		 super.paintComponent(g2);
	     doDrawing(g2);
	    }    
	 
	 public Icon getIcon(){
		 icon = (Icon) new BiomorphIcon(31, g2d);
		 return icon;
	 }
	 
	 public void drawAll(Graphics2D g2d, double x, double y){
			
		 g2d.scale(x, y);
		// g2d.translate(-100, 0);

		 //draw head
		 Polygon hPoints = pc.getHeadPoints();
		 g2d.drawPolygon(hPoints);

		 //draw eyes
		 Pair<Polygon, Polygon> ePoints = pc.getAllEyePoints();
		 g2d.drawPolygon(ePoints.x);
		 g2d.drawPolygon(ePoints.y);

		 //draw eyebrows
		 Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> ebPoints = pc.getEyebrowPoints();
		 g2d.drawLine(ebPoints.x.get(0).x, ebPoints.x.get(0).y, ebPoints.x.get(1).x, ebPoints.x.get(1).y);
		 g2d.drawLine(ebPoints.y.get(0).x, ebPoints.y.get(0).y, ebPoints.y.get(1).x, ebPoints.y.get(1).y);

		 //draw nose
		 HashMap<Integer, Pair<Integer, Integer>> nPoints = pc.getNosePoints();
		 g2d.drawLine(nPoints.get(0).x, nPoints.get(0).y, nPoints.get(1).x, nPoints.get(1).y);
		 g2d.drawLine(nPoints.get(1).x, nPoints.get(1).y, nPoints.get(2).x, nPoints.get(2).y);

		 //draw mouth
		 Pair<HashMap<Integer, Pair<Integer, Integer>>, HashMap<Integer, Pair<Integer, Integer>>> mPoints = pc.getMouthPoints();
		 g2d.drawLine(mPoints.x.get(0).x, mPoints.x.get(0).y, mPoints.x.get(1).x, mPoints.x.get(1).y);
		 g2d.drawLine(mPoints.x.get(1).x, mPoints.x.get(1).y, mPoints.x.get(2).x, mPoints.x.get(2).y);

		 g2d.drawLine(mPoints.y.get(0).x, mPoints.y.get(0).y, mPoints.y.get(1).x, mPoints.y.get(1).y);
		 g2d.drawLine(mPoints.y.get(1).x, mPoints.y.get(1).y, mPoints.y.get(2).x, mPoints.y.get(2).y);
			
	 }
	 
	 private class BiomorphIcon implements Icon{

		 private int size;
		 private Graphics2D g2d;
		 
		 public BiomorphIcon(int size, Graphics2D g2d){
			 this.g2d = g2d;
			 this.size = size;
		 }
		 
		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) g;
			drawAll(g2d, 0.1, 0.1);
		}
		 
	 }

}
