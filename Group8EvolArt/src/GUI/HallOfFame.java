package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Stage2.DNAFactory;
/**
 * Class responsible for hall of fame gui.
 * @author Mohammed, Sheraz, Aman
 */
public class HallOfFame extends JFrame {

	private JPanel contentPane;
	public JPanel generationPanel = new JPanel(new GridLayout(3, 3, 3, 3));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HallOfFame frame = new HallOfFame();  //create new frame for hall of fame
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HallOfFame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		generationPanel.setBounds(5, 100, 258, 375);
		Border blueLine = BorderFactory.createLineBorder(Color.blue);
		generationPanel.setBorder(blueLine);
		
		DNAFactory dnaFactory=new DNAFactory(); // create new DNA
		
		JButton clearButton = new JButton("Clear Hall of Fame");
		clearButton.setBounds(5, 5, 137, 47);
		contentPane.add(clearButton);
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				generationPanel.removeAll();
				generationPanel.repaint();
			}
		});


		contentPane.add(generationPanel);
	}

}
