package Stage2;

import java.awt.Color;
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
	private JLabel label = new JLabel();
	private ImageIcon icon;
	
	public JLabel getLabel() {
		return label;
	}

	public BiomorphPanel(){
		this.add(label);
	}
	
	private void doDrawing(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		//g2d.scale(0.1, 0.1);
		BufferedImage img = new BufferedImage(31, 31, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dIcon = (Graphics2D) img.getGraphics();
		
		drawAll(g2d);
		drawAll(g2dIcon);
		
		g2dIcon.setColor(Color.BLACK);
		g2dIcon.fillRect(0, 0, 31, 31);
		g2dIcon.drawImage(img, null, 0, 0);
		icon = new ImageIcon(img);
		//icon = new ImageIcon(gra);
	}
	
	 @Override
	 public void paintComponent(Graphics g) {       
		 Graphics2D g2 = (Graphics2D) g;
		 //scaling and translating to fit into mini panels in GUI
		// g2.scale(0.15, 0.15);
		 //g2.translate(-100.0, 0.0);
		 super.paintComponent(g2);
	     doDrawing(g2);
	    }    
	 
	 public ImageIcon getIcon(){
		 return icon;
	 }
	 
	 public void drawAll(Graphics2D g2d){
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

}
