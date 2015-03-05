package Prototype;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Temporary class responsible for the prototype GUI.
 * @author Josh Merritt
 *
 */
public class ProtoGUI extends JFrame {

	/**
	 * Constructor creating a ProtoGUIPanel panel in a sized window with basic GUI features.
	 */
    public ProtoGUI() {
        
        setTitle("Evolutionary Art - Group 8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new ProtoGUIPanel());
        setSize(360, 350);
    }

    /**
     * Main method required for running the program. Shows lines drawn in ProtoGUIPanel.
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                ProtoGUI lines = new ProtoGUI();
                lines.setVisible(true);
            }
        });
    }
}