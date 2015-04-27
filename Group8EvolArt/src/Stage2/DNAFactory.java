package Stage2;

import java.util.ArrayList;
import java.util.Random;
/**
 * Class responsible for main gui.
 * @author Mohammed, Sheraz, Aman, 
 */
public class DNAFactory {

	private Random random = new Random();
	private ArrayList<BiomorphPanel> generation;

	
	 // get 9 faces of DNA Factory
	
	public ArrayList<BiomorphPanel> getGeneration(int biomorf1Code) {
		ArrayList<BiomorphPanel> generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		boolean b = false;
		while (i < 9) {
				generation.add(new BiomorphPanel(i,true,biomorf1Code));
			i++;
		}
		return generation;
	}

	
	 //get 9 faces of random generation
	
	public ArrayList<BiomorphPanel> getGeneration() {
		
		return generation;
	}

	public DNAFactory() {
		// arraylist of biomorphs to be shown in GUI
		generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		// adds 9 biomorphPanels
		while (i < 9) {
			generation.add(new BiomorphPanel(i,false,10));
			i++;
		}
	}

	public DNA generateDNA() {
		DNA dna;

		ArrayList<Integer> head = new ArrayList<>();
		ArrayList<Integer> eyes = new ArrayList<>();
		ArrayList<Integer> eyebrows = new ArrayList<>();
		ArrayList<Integer> nose = new ArrayList<>();

		head.add(random.nextInt(999) + 1);
		head.add(random.nextInt(999) + 1);
		head.add(random.nextInt(999) + 1);

		eyes.add(random.nextInt(999) + 1);
		eyes.add(random.nextInt(999) + 1);
		eyes.add(random.nextInt(999) + 1);

		eyebrows.add(random.nextInt(999) + 1);
		eyebrows.add(random.nextInt(999) + 1);
		eyebrows.add(random.nextInt(999) + 1);

		nose.add(random.nextInt(999) + 1);
		nose.add(random.nextInt(999) + 1);
		nose.add(random.nextInt(999) + 1);

		dna = new DNA(head, eyes, eyebrows, nose);

		return dna;
	}
}
