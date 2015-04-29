package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Mohammed Baseel, Abdul Ahmed
 *
 */
public class ArchivedBiomorphInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArchivedBiomorphInterface frame = new ArchivedBiomorphInterface();
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
	public ArchivedBiomorphInterface() {
		setTitle("Archived Biomorph");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	JButton btnLoadDna = new JButton("LOAD DNA");
	btnLoadDna.setBounds(376, 420, 112, 47);
	contentPane.add(btnLoadDna);
	
	Label label = new Label("image 1");
	label.setFont(new Font("Dialog", Font.ITALIC, 14));
	label.setBounds(50, 11, 169, 14);
	contentPane.add(label);
	
	Label label_2 = new Label("image 2");
	label_2.setFont(new Font("Dialog", Font.ITALIC, 14));
	label_2.setBounds(230, 11, 169, 14);
	contentPane.add(label_2);
	
	Label label_3 = new Label("image 3");
	label_3.setFont(new Font("Dialog", Font.ITALIC, 14));
	label_3.setBounds(400, 11, 169, 14);
	contentPane.add(label_3);
	
	Label label_4 = new Label("image 4");
	label_4.setFont(new Font("Dialog", Font.ITALIC, 14));
	label_4.setBounds(50, 200, 169, 14);
	contentPane.add(label_4);
	
	Label label_5 = new Label("image 5");
	label_5.setFont(new Font("Dialog", Font.ITALIC, 14));
	label_5.setBounds(230, 200, 169, 14);
	contentPane.add(label_5);
	
	Label label_6 = new Label("image 6");
	label_6.setFont(new Font("Dialog", Font.ITALIC, 14));
	label_6.setBounds(400, 200, 169, 14);
	contentPane.add(label_6);
}
}
