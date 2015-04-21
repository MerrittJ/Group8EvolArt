package Stage2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;

public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
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
	public Options() {
		setType(Type.UTILITY);
		setTitle("OPTIONS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setToolTipText("");
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(10);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(10);
		slider.setBounds(87, 11, 200, 26);
		contentPane.add(slider);
		
		JLabel lblOption = new JLabel("Option 1");
		lblOption.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOption.setBounds(10, 11, 66, 14);
		contentPane.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("Option 2");
		lblOption_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOption_1.setBounds(10, 71, 66, 14);
		contentPane.add(lblOption_1);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(10);
		slider_1.setToolTipText("");
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMaximum(10);
		slider_1.setBounds(87, 71, 200, 26);
		contentPane.add(slider_1);
		
		JLabel lblOption_2 = new JLabel("Option 3");
		lblOption_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOption_2.setBounds(10, 132, 66, 14);
		contentPane.add(lblOption_2);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(10);
		slider_2.setToolTipText("");
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMaximum(10);
		slider_2.setBounds(87, 132, 200, 26);
		contentPane.add(slider_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(92, 186, 29, 20);
		contentPane.add(spinner);
		
		JLabel lblOption_3 = new JLabel("Option 3");
		lblOption_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOption_3.setBounds(10, 189, 66, 14);
		contentPane.add(lblOption_3);
	}
}
