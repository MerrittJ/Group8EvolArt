package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class InternalFrame extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = -707201647311066773L;
static JDesktopPane desktopPane = new JDesktopPane();
JInternalFrame intFrame = new JInternalFrame("image 1");
JInternalFrame intFrame2 = new JInternalFrame("image 2");
JInternalFrame intFrame3 = new JInternalFrame("image 3");
JInternalFrame intFrame4 = new JInternalFrame("image 4");
JInternalFrame intFrame5 = new JInternalFrame("image 5");
JInternalFrame intFrame6 = new JInternalFrame("image 6");



public InternalFrame(){
	intFrame.setBounds(10, 30, 200,140);
	intFrame.setVisible(true);
	desktopPane.add(intFrame);
	add(desktopPane);
	
	
	intFrame2.setVisible(true);
	intFrame2.setBounds(10, 200, 200, 140);
	desktopPane.add(intFrame2);
	add(desktopPane);
	
	intFrame3.setVisible(true);
	intFrame3.setBounds(200, 30, 200, 140);
	desktopPane.add(intFrame3);
	add(desktopPane);
	
	intFrame4.setVisible(true);
	intFrame4.setBounds(200, 200, 200, 140);
	desktopPane.add(intFrame4);
	add(desktopPane);
	
	intFrame5.setVisible(true);
	intFrame5.setBounds(390, 30, 200, 140);
	desktopPane.add(intFrame5);
	add(desktopPane);
	
	intFrame6.setVisible(true);
	intFrame6.setBounds(390, 200, 200, 140);
	desktopPane.add(intFrame6);
	add(desktopPane);
	
	
	
}
public static void main(String[] args){
	InternalFrame iFrame = new InternalFrame();
	iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	iFrame.setSize(640,480);
	iFrame.setVisible(true);
	
	JButton btnLoadDna = new JButton("LOAD");
	btnLoadDna.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			LoadString open = new LoadString();
			open.setVisible(true);
		}
	});
	btnLoadDna.setBounds(500, 380,112,47);
	desktopPane.add(btnLoadDna);
}
}

