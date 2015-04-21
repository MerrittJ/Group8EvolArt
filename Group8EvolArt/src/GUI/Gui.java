package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Stage2.*;

import java.awt.Label;
import java.awt.Font;
import java.awt.Panel;
import java.util.ArrayList;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel selectedBio1;
	private JPanel selectedBio2;		
	private boolean changeBioPan1;
	private Pair<String, String> dnaToMutate;
	private Control c;

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
		
		c = new Control();
		changeBioPan1 = true;

		BMMouseListener ml = new BMMouseListener();
		
		setTitle("BIOMORPH GENERATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JButton btnNewButton = new JButton("OPTIONS");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Options open = new Options();
//				open.setVisible(true);
//			}
//		});
//		btnNewButton.setBounds(10, 460, 112, 47);
//		contentPane.add(btnNewButton);
		
		JButton btnMutate = new JButton("MUTATE");
		btnMutate.setBounds(132, 460, 112, 47);
		btnMutate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//dnaToMutate.x = selectedBio1.getComponent(0);
				BiomorphPanel bp1 = (BiomorphPanel) selectedBio1.getComponent(0);
				System.out.println(bp1.getDNAString());
			}
		});
		contentPane.add(btnMutate);
		
		JButton btnSave = new JButton("HALL OF FAME");
		btnSave.setBounds(254, 460, 130, 47);
		contentPane.add(btnSave);
		
//		JButton btnSaveDna = new JButton("SAVE DNA");
//		btnSaveDna.setBounds(376, 460, 112, 47);
//		contentPane.add(btnSaveDna);
		
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
		
//		JButton btnStartTracking = new JButton("START TRACKING");
//		btnStartTracking.setBounds(473, 163, 137, 47);
//		contentPane.add(btnStartTracking);
		
//		JButton btnStopTracking = new JButton("STOP TRACKING");
//		btnStopTracking.setBounds(473, 221, 137, 47);
//		contentPane.add(btnStopTracking);
		
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
		selectedBio1 = new JPanel();
		selectedBio1.setLayout(new BorderLayout());
		selectedBio1.setBounds(287, 32, 178, 189);
		//selectedBio1.
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		selectedBio1.setBorder(blackLine);
		contentPane.add(selectedBio1);
		
		//bio2
		selectedBio2 = new JPanel();
		selectedBio2.setBounds(287, 265, 178, 189);
		Border redLine = BorderFactory.createLineBorder(Color.red);
		selectedBio2.setBorder(redLine);
		contentPane.add(selectedBio2);
		
		//generation panel
		JPanel generationPanel = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel.setBounds(10, 32, 258, 375);
		Border blueLine = BorderFactory.createLineBorder(Color.blue);
		generationPanel.setBorder(blueLine);
		
		
		for (BiomorphPanel bp : c.getGeneration()){
			//bp.setBorder(blueLine);
			bp.addMouseListener(ml);
			generationPanel.add(bp);
		}
		
		contentPane.add(generationPanel);
		
	}
	
	private class BMMouseListener implements MouseListener{

		private BiomorphPanel bp;
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if (changeBioPan1 == true) {
				selectedBio1.add(e.getComponent(), 0);
				selectedBio1.getComponent(0).setLocation(50, 40);
				System.out.println("y " + e.getComponent().toString());
				//selectedBio1.repaint();
				changeBioPan1 = false;
			}
			else if (changeBioPan1 == false){
				selectedBio2.add(e.getComponent(), 0);
				selectedBio2.getComponent(0).setLocation(50, 40);
				System.out.println("x " + e.getComponent().toString());
				selectedBio2.repaint();
				changeBioPan1 = true;
			}
			System.out.println("test" + changeBioPan1);
		}
		
		public BiomorphPanel getBiomorphPanel(){
			return bp;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}


