// place names here please: Josh,

package Stage2;

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
public class TempGUI extends JFrame {

	/**
	 * Constructor creating a ProtoGUIPanel panel in a sized window with basic GUI features.
	 */
    public TempGUI() {
        
        setTitle("Evolutionary Art - Group 8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BiomorphPanel());
        setSize(360*2, 350*2);
    }

    /**
     * Main method required for running the program. Shows lines drawn in ProtoGUIPanel.
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                TempGUI lines = new TempGUI();
                lines.setVisible(true);
            }
        });
    }
}