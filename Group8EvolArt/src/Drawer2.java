import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Drawer2 extends JFrame {

    public Drawer2() {

        initUI();
    }
    
    private void initUI() {
        
        setTitle("Lines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(new Surface());
        
        setSize(350, 350);
        setLocationRelativeTo(null);        
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                Drawer lines = new Drawer();
                lines.setVisible(true);
            }
        });
    }
}