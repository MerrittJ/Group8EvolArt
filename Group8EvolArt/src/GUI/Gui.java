
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import util.ComponentImageCapture;
import Stage2.BiomorphPanel;
import Stage2.DNAFactory;

/**
 * GUI class.
 * @author Mohammed Baseel, Sheraz Atiq, Aman Kauldhar, Josh Merritt
 */
public class Gui extends JFrame {

	/**
	 * Highest level JPanel, holding all aspects of the GUI
	 */
	private JPanel contentPane;
	/**
	 * JPanel to hold a biomorph selected from the current generation
	 */
	private JPanel selectedBio1;
	/**
	 * JPanel to hold a biomorph selected from the current generation
	 */
	private JPanel selectedBio2;
	/**
	 * Boolean to change focus between selectedBio panels when updating the container
	 */
	boolean changeBioPan1;
	/**
	 * Boolean changing focus between selectedBio panels regarding the Hall of Fame
	 */
	private boolean flag = true;
	/**
	 * JPanels each holding a biomorph to be displayed in the GUI
	 */
	private JPanel generationPanel, generationPanel2, generationPanel3, 
		generationPanel9, generationPanel10, generationPanel4, generationPanel5, 
		generationPanel6, generationPanel7, generationPanel8;
	/**
	 * Mouse listener handling clicks on panels
	 */
	BMMouseListener ml = new BMMouseListener();
	/**
	 * Integer used in the mutation process to differentiate each biomorph from the others in its generation
	 */
	private int biomorf1Code = 1;
	/**
	 * ArrayList holding all of the BiomorphPanels in their Component form
	 */
	List<Component> componentsList = new ArrayList<Component>();
	/**
	 * Main GUI frame
	 */
	static Gui frame;
	/**
	 * Boolean involved in opening the Hall Of Fame frame
	 */
	private boolean openHallOfframe;

	/**
	 * Main method to launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor creating the primary frame for the GUI.
	 */
	public Gui() {

		changeBioPan1 = true;

		setTitle("BIOMORPH GENERATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final HallOfFame frame = new HallOfFame();

		// mutate GUI button with action
		JButton btnMutate = new JButton("MUTATE");
		btnMutate.setName("Mutate");
		btnMutate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (selectedBio1.getComponents().length == 0
						|| selectedBio2.getComponents().length == 0) {
					return;
				}
				contentPane.remove(generationPanel);
				selectedBio1.removeAll();
				selectedBio1.repaint();
				selectedBio2.removeAll();
				selectedBio2.repaint();

				// frame visible with random generation
				if (biomorf1Code == 1) {
					biomorf1Code = 2;
					hideAllGenerationPanel();
					generationPanel2.setVisible(true);
				} else if (biomorf1Code == 2) {
					biomorf1Code = 3;
					hideAllGenerationPanel();
					generationPanel3.setVisible(true);
				} else if (biomorf1Code == 3) {
					biomorf1Code = 4;
					hideAllGenerationPanel();
					generationPanel4.setVisible(true);
				} else if (biomorf1Code == 4) {
					biomorf1Code = 5;
					hideAllGenerationPanel();
					generationPanel5.setVisible(true);
				} else if (biomorf1Code == 5) {
					biomorf1Code = 6;
					hideAllGenerationPanel();
					generationPanel6.setVisible(true);
				} else if (biomorf1Code == 6) {
					biomorf1Code = 7;
					hideAllGenerationPanel();
					generationPanel7.setVisible(true);
				} else if (biomorf1Code == 7) {
					biomorf1Code = 8;
					hideAllGenerationPanel();
					generationPanel8.setVisible(true);
				} else if (biomorf1Code == 8) {
					biomorf1Code = 9;
					hideAllGenerationPanel();
					generationPanel9.setVisible(true);
				} else {
					biomorf1Code = 1;
					hideAllGenerationPanel();
					generationPanel10.setVisible(true);
				}

			}

			private void hideAllGenerationPanel() {
				generationPanel2.setVisible(false);
				generationPanel3.setVisible(false);
				generationPanel4.setVisible(false);
				generationPanel5.setVisible(false);
				generationPanel6.setVisible(false);
				generationPanel7.setVisible(false);
				generationPanel8.setVisible(false);
				generationPanel9.setVisible(false);
				generationPanel10.setVisible(false);
			}
		});

		
		
		// add frames of DNA generated Faces
		DNAFactory dnaFactory = new DNAFactory();
		generationPanel2 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel2.setBounds(10, 32, 260, 378);
		Border blueLine = BorderFactory.createLineBorder(Color.blue);
		generationPanel2.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(1)) {
			bp.addMouseListener(ml);
			generationPanel2.add(bp);
		}
		contentPane.add(generationPanel2);
		generationPanel2.setVisible(false);

		
		
		generationPanel3 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel3.setBounds(10, 32, 260, 378);
		generationPanel3.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(2)) {
			bp.addMouseListener(ml);
			generationPanel3.add(bp);
		}
		contentPane.add(generationPanel3);
		generationPanel3.setVisible(false);

		
		
		generationPanel4 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel4.setBounds(10, 32, 260, 378);
		generationPanel4.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(3)) {
			bp.addMouseListener(ml);
			generationPanel4.add(bp);
		}
		contentPane.add(generationPanel4);
		generationPanel4.setVisible(false);

		
		
		generationPanel5 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel5.setBounds(10, 32, 260, 378);
		generationPanel5.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(4)) {
			bp.addMouseListener(ml);
			generationPanel5.add(bp);
		}
		contentPane.add(generationPanel5);
		generationPanel5.setVisible(false);

		
		
		generationPanel6 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel6.setBounds(10, 32, 260, 378);
		generationPanel6.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(5)) {
			bp.addMouseListener(ml);
			generationPanel6.add(bp);
		}
		contentPane.add(generationPanel6);
		generationPanel6.setVisible(false);

		
		
		generationPanel7 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel7.setBounds(10, 32, 260, 378);
		generationPanel7.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(6)) {
			bp.addMouseListener(ml);
			generationPanel7.add(bp);
		}
		contentPane.add(generationPanel7);
		generationPanel7.setVisible(false);

		
		
		generationPanel8 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel8.setBounds(10, 32, 260, 378);
		generationPanel8.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(7)) {
			bp.addMouseListener(ml);
			generationPanel8.add(bp);
		}
		contentPane.add(generationPanel8);
		generationPanel8.setVisible(false);

		
		
		generationPanel9 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel9.setBounds(10, 32, 260, 378);
		generationPanel9.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(8)) {
			bp.addMouseListener(ml);
			generationPanel9.add(bp);
		}
		contentPane.add(generationPanel9);
		generationPanel9.setVisible(false);

		
		
		generationPanel10 = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel10.setBounds(10, 32, 260, 378);
		generationPanel10.setBorder(blueLine);
		for (BiomorphPanel bp : dnaFactory.getGeneration(9)) {
			bp.addMouseListener(ml);
			generationPanel10.add(bp);
		}
		contentPane.add(generationPanel10);
		generationPanel10.setVisible(false);

		btnMutate.setBounds(132, 460, 112, 47);
		contentPane.add(btnMutate);

		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpInterface open = new HelpInterface();
				open.setVisible(true);
			}
		});

		btnHelp.setBounds(498, 11, 112, 47);
		contentPane.add(btnHelp);

		// save to hall of fame button 	
		JButton btnStopTracking1 = new JButton("Save to Hall of Fame");
		btnStopTracking1.setName("SaveToHallFame");
		btnStopTracking1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (true) {
					final JInternalFrame intFrame = new JInternalFrame("");
					intFrame.setBounds(287, 32, 178, 189);
					intFrame.setVisible(true);
					JButton btnRemove = new JButton("X");
					btnRemove.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.generationPanel.remove(intFrame);
							frame.generationPanel.repaint();
						}
					});
					btnRemove.setBounds(0, 0, 50, 20);
					intFrame.add(btnRemove);
					// reverse added code
					JButton btnAddMain = new JButton("B");
					btnAddMain.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (changeBioPan1 == true) {
								selectedBio1.add(componentsList
										.get(frame.generationPanel
												.getComponents().length - 1), 0);
								selectedBio1.getComponent(0)
										.setLocation(50, 40);
								selectedBio1.repaint();
								changeBioPan1 = false;
							} else if (changeBioPan1 == false) {
								selectedBio2.add(componentsList
										.get(frame.generationPanel
												.getComponents().length - 1), 0);
								selectedBio2.getComponent(0)
										.setLocation(50, 40);
								selectedBio2.repaint();
								changeBioPan1 = true;
							}
							frame.generationPanel.remove(intFrame);
							frame.generationPanel.repaint();
						}
					});
					btnAddMain.setBounds(100, 0, 50, 20);
					intFrame.add(btnAddMain);

					Component[] components = selectedBio1.getComponents();
					Component[] selectedBioComponents = selectedBio2
							.getComponents();
					if (components.length == 0
							&& selectedBioComponents.length == 0) {
						return;
					}

					if (flag) {
						for (Component comp : components) {
							intFrame.add(comp);
							componentsList.add(comp);
							break;
						
						}
						selectedBio1.repaint();
						flag = false;
					} else {

						for (Component component : selectedBioComponents) {
							intFrame.add(component);
							componentsList.add(component);
							break;
						}
						selectedBio2.repaint();
						flag = true;
					}

					frame.generationPanel.add(intFrame);
					frame.generationPanel.repaint();
				}
			}
		});

		btnStopTracking1.setBounds(473, 280, 137, 47);
		contentPane.add(btnStopTracking1);

		JButton clearButton = new JButton("Clear Hall of Fame");
		clearButton.setName("ClearHallFame");
		clearButton.setBounds(473, 338, 137, 47);
		contentPane.add(clearButton);

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.generationPanel.removeAll();
				frame.generationPanel.repaint();
			}
		});
		
		JButton saveBio1 = new JButton("Save Biomorph 1");
		saveBio1.setBounds(473, 170, 137, 47);
		contentPane.add(saveBio1);
		
		saveBio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Save Image");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      BufferedImage img = ComponentImageCapture.getScreenShot(selectedBio1);
				try {
				      ImageIO.write(img, "png",
								new File(chooser.getSelectedFile() + File.separator + "Biomorph1.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			    } else {
			      System.out.println("No Selection ");
			    }
			}
		});
		
		
		JButton saveBio2 = new JButton("Save Biomorph 2");
		saveBio2.setBounds(473, 225, 137, 47);
		contentPane.add(saveBio2);
		
		saveBio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Save Image");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      BufferedImage img = ComponentImageCapture.getScreenShot(selectedBio2);
				try {
				      ImageIO.write(img, "png",
								new File(chooser.getSelectedFile() + File.separator + "Biomorph2.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			    } else {
			      System.out.println("No Selection ");
			    }
									
			}
		});
		
		JButton OpenHallOfFrame = new JButton("Open Hall Of Fame");
		OpenHallOfFrame.setName("OpenHallOfFame");
		OpenHallOfFrame.setBounds(473, 395, 137, 47);
		contentPane.add(OpenHallOfFrame);
		
		OpenHallOfFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!openHallOfframe){
					frame.setVisible(true);
					openHallOfframe = true;
				}else{
					frame.setVisible(false);
					openHallOfframe = false;
				}	
			}
		});

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

		// bio1
		selectedBio1 = new JPanel();
		selectedBio1.setLayout(new BorderLayout());
		selectedBio1.setBounds(287, 32, 178, 189);
		// selectedBio1.
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		selectedBio1.setBorder(blackLine);
		contentPane.add(selectedBio1);

		// bio2
		selectedBio2 = new JPanel();
		selectedBio2.setBounds(287, 265, 178, 189);
		Border redLine = BorderFactory.createLineBorder(Color.red);
		selectedBio2.setBorder(redLine);
		contentPane.add(selectedBio2);

		// generation panel
		generationPanel = new JPanel(new GridLayout(3, 3, 3, 3));
		generationPanel.setBounds(10, 32, 258, 375);
		generationPanel.setBorder(blueLine);
		createNewDNAFactory();
	}

	/**
	 * Method to create a DNA factory and populate it with BiomorphPanels
	 */
	private void createNewDNAFactory() {
		DNAFactory dnaFactory = new DNAFactory();
		for (BiomorphPanel bp : dnaFactory.getGeneration()) {
			bp.addMouseListener(ml);
			bp.setName("generationPanel");
			generationPanel.add(bp);
		}

		contentPane.add(generationPanel);
	}
	
	/** 
	 * Simple mouse listener class to deal with clicks on panels (and sending the clicked component to the appropriate focus box.
	 * @author Josh Merritt
	 */
	private class BMMouseListener implements MouseListener {

		private BiomorphPanel bp;

		/**
		 * Click listener method. Cycles between sending a clicked biomorph to 'selectedBio1' and 'selectedBio2', the two focus boxes.
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			BiomorphPanel bp = (BiomorphPanel) e.getSource();
			if (changeBioPan1 == true) {
				selectedBio1.add(e.getComponent(), 0);
				selectedBio1.getComponent(0).setLocation(50, 40);
				selectedBio1.repaint();
				changeBioPan1 = false;
			} else if (changeBioPan1 == false) {
				selectedBio2.add(e.getComponent(), 0);
				selectedBio2.getComponent(0).setLocation(50, 40);
				selectedBio2.repaint();
				changeBioPan1 = true;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
