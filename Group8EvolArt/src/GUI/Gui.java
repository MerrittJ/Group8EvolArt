package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Stage2.*;

import java.awt.Label;
import java.awt.Font;
import java.awt.Panel;

public class Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		
		Control c = new Control();
		BiomorphPanel selected1 = null;
		BiomorphPanel selected2 = null;
		BMMouseListener ml = new BMMouseListener();
		
		setTitle("BIOMORPH GENERATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OPTIONS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options open = new Options();
				open.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 460, 112, 47);
		contentPane.add(btnNewButton);
		
		JButton btnMutate = new JButton("MUTATE");
		btnMutate.setBounds(132, 460, 112, 47);
		contentPane.add(btnMutate);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(254, 460, 112, 47);
		contentPane.add(btnSave);
		
		JButton btnSaveDna = new JButton("SAVE DNA");
		btnSaveDna.setBounds(376, 460, 112, 47);
		contentPane.add(btnSaveDna);
		
		JButton btnLoadDna = new JButton("LOAD DNA");
		btnLoadDna.setBounds(498, 460, 112, 47);
		contentPane.add(btnLoadDna);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpInterface open = new HelpInterface();
				open.setVisible(true);
			}
		});
		btnHelp.setBounds(498, 11, 112, 47);
		contentPane.add(btnHelp);
		
		JButton btnStartTracking = new JButton("START TRACKING");
		btnStartTracking.setBounds(473, 163, 137, 47);
		contentPane.add(btnStartTracking);
		
		JButton btnStopTracking = new JButton("STOP TRACKING");
		btnStopTracking.setBounds(473, 221, 137, 47);
		contentPane.add(btnStopTracking);
		
		Label label = new Label("Biomorph 1");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(303, 11, 94, 14);
		contentPane.add(label);
		
		Label label_1 = new Label("Biomorph 2");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(303, 245, 94, 14);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Generation of Artwork");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(10, 11, 169, 14);
		contentPane.add(label_2);
		
		//bio1
		JPanel panel = new JPanel();
		panel.setBounds(287, 32, 178, 189);
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		panel.setBorder(blackLine);
		if (ml.getBiomorphPanel() != null){
			panel.add(ml.getBiomorphPanel());
		}
		contentPane.add(panel);
		
		//bio2
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 265, 178, 189);
		Border redLine = BorderFactory.createLineBorder(Color.red);
		panel_1.setBorder(redLine);
		contentPane.add(panel_1);
		
		//generation panel
		JPanel panel_2 = new JPanel(new GridLayout(3, 3, 3, 3));
		panel_2.setBounds(10, 32, 258, 375);
		Border blueLine = BorderFactory.createLineBorder(Color.blue);
		panel_2.setBorder(blueLine);
		contentPane.add(panel_2);
		
		
		for (BiomorphPanel bp : c.getGeneration()){
			bp.setBorder(blueLine);
			bp.addMouseListener(ml);
			panel_2.add(bp);
		}
		
		
		contentPane.add(panel_2);
		
	}
}
