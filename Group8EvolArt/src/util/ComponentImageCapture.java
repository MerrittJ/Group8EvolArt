package util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 * Create a screenshot of a component.
 * 
 * @author Sheraz, Aman
 */
public class ComponentImageCapture {

	static final String HELP = "Type Ctrl-0 to get a screenshot of the current GUI.\n"
			+ "The screenshot will be saved to the current "
			+ "directory as 'screenshot.png'.";

	public static BufferedImage getScreenShot(Component component) {

		BufferedImage image = new BufferedImage(component.getWidth(),
				component.getHeight(), BufferedImage.TYPE_INT_RGB);

		component.paint(image.getGraphics()); 
		return image;
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				final JFrame f = new JFrame("Test Screenshot");

				JMenuItem screenshot = new JMenuItem("Screenshot");
				screenshot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,
						InputEvent.CTRL_DOWN_MASK));
				screenshot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						BufferedImage img = getScreenShot(f.getContentPane());
						JOptionPane.showMessageDialog(
								null,
								new JLabel(new ImageIcon(img.getScaledInstance(
										img.getWidth(null) / 2,
										img.getHeight(null) / 2,
										Image.SCALE_SMOOTH))));
						try {
							// write the image as a PNG
							ImageIO.write(img, "png",
									new File("screenshot.png"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				JMenu menu = new JMenu("Other");
				menu.add(screenshot);
				JMenuBar mb = new JMenuBar();
				mb.add(menu);
				f.setJMenuBar(mb);

				JPanel p = new JPanel(new BorderLayout(5, 5));
				p.setBorder(new TitledBorder("Main GUI"));
				p.add(new JScrollPane(new JTree()), BorderLayout.WEST);
				p.add(new JScrollPane(new JTextArea(HELP, 10, 30)),
						BorderLayout.CENTER);

				f.setContentPane(p);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}