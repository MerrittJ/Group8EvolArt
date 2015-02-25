package Prototype;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Class responsible for drawing biomorph in a GUI. Currently standalone, will be implemented into a full GUI in term 2.
 * @author Josh Merritt
 *
 */
public class ProtoGUI extends JFrame {

	/**
	 * Constructor creating a Surface object in a sized window with basic GUI features.
	 */
    public ProtoGUI() {
        
        setTitle("Evolutionary Art - Group 8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Surface());
        setSize(360, 350);       
    }

    /**
     * Main method required for running the program. Shows lines drawn in Surface.
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