package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoadString extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadString frame = new LoadString();
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
	public LoadString() {
		setTitle("LoadSting");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(3,1));
		
		JButton btnok = new JButton("OK");
		btnok.setBounds(10, 200, 50, 47);
		JTextField text = new JTextField();
		JLabel label = new JLabel("Enter string");
		input.add(label);
		input.add(text);
		input.add(btnok);
		contentPane.add(input);
		
		setContentPane(contentPane);
	}

}
