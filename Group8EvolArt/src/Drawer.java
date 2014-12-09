import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Drawer extends JFrame {

    public Drawer() {

        initUI();
    }

    private void initUI() {

        setTitle("Simple Java 2D example");

        add(new Surface());

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Drawer dr = new Drawer();
                dr.setVisible(true);
            }
        });
    }
}
