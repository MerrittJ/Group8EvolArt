package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Stage2.BiomorphPanel;

public class BMMouseListener implements MouseListener{

	private BiomorphPanel bp;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		new ListDisplayPanel().display();
		//System.out.println("lol");
	}
	
	public BiomorphPanel getBiomorphPanel(){
		return bp;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
