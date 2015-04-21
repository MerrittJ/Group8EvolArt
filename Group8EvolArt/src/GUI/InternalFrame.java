package GUI;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Stage2.BiomorphPanel;

public class InternalFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -707201647311066773L;
	static JDesktopPane desktopPane = new JDesktopPane();
	JInternalFrame intFrame = new JInternalFrame("1");
	JInternalFrame intFrame2 = new JInternalFrame("2");
	JInternalFrame intFrames4 = new JInternalFrame("4");
	JInternalFrame intFrames5 = new JInternalFrame("5");
	JInternalFrame intFrame7 = new JInternalFrame("7");
	JInternalFrame intFrame8 = new JInternalFrame("8");
	JInternalFrame intFrames3 = new JInternalFrame("3");
	JInternalFrame intFrames6 = new JInternalFrame("6");
	JInternalFrame intFrame9 = new JInternalFrame("9");

	public InternalFrame() {

		ArrayList<BiomorphPanel> generation = new ArrayList<BiomorphPanel>();

		int i = 0;
		while (i < 9) {
//			generation.add(new BiomorphPanel(i,true,10));
			i++;
		}

		intFrame.setBounds(10, 30, 200, 140);
		intFrame.setVisible(true);
		intFrame.add(generation.get(0)); 
		desktopPane.add(intFrame);
		add(desktopPane);

		intFrame2.setVisible(true);
		intFrame2.setBounds(10, 200, 200, 140);
		intFrame2.add(generation.get(1));
		desktopPane.add(intFrame2);
		add(desktopPane);

		intFrames3.setVisible(true);
		intFrames3.setBounds(10, 370, 200, 140);
		intFrames3.add(generation.get(2));
		desktopPane.add(intFrames3);
		add(desktopPane);

		intFrames4.setVisible(true);
		intFrames4.setBounds(200, 30, 200, 140);
		intFrames4.add(generation.get(3));
		desktopPane.add(intFrames4);
		add(desktopPane);

		intFrames5.setVisible(true);
		intFrames5.setBounds(200, 200, 200, 140);
		intFrames5.add(generation.get(4));
		desktopPane.add(intFrames5);
		add(desktopPane);

		intFrames6.setVisible(true);
		intFrames6.setBounds(200, 370, 200, 140);
		intFrames6.add(generation.get(5));
		desktopPane.add(intFrames6);
		add(desktopPane);

		intFrame7.setVisible(true);
		intFrame7.setBounds(390, 30, 200, 140);
		intFrame7.add(generation.get(6));
		desktopPane.add(intFrame7);
		add(desktopPane);

		intFrame8.setVisible(true);
		intFrame8.setBounds(390, 200, 200, 140);
		intFrame8.add(generation.get(7));
		desktopPane.add(intFrame8);
		add(desktopPane);

		intFrame9.setVisible(true);
		intFrame9.setBounds(390, 370, 200, 140);
		intFrame9.add(generation.get(8));
		desktopPane.add(intFrame9);
		add(desktopPane);

	}

	public static void main(String[] args) {
		InternalFrame iFrame = new InternalFrame();
		iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		iFrame.setSize(640, 640);
		iFrame.setVisible(true);

		JButton btnLoadDna = new JButton("LOAD");
		btnLoadDna.setBounds(500, 540, 112, 47);
		desktopPane.add(btnLoadDna);
	}
}
