package Stage2;

import java.util.ArrayList;
import java.util.Random;
/**
 * Class responsible for dealing with DNA.
 * @author Mohammed, Sheraz, Aman
 */
public class DNAFactory {

	private Random random = new Random();
	private ArrayList<BiomorphPanel> generation;

	/**
	 * get egeration face of DNA Factory
	 * @param biomorph1Code
	 * @return
	 */
	public ArrayList<BiomorphPanel> getGeneration(int biomorph1Code) {
		ArrayList<BiomorphPanel> generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		boolean b = false;
		// adds 9 biomorphPanels
		while (i < 9) {
				generation.add(new BiomorphPanel(i,true,biomorph1Code));
			i++;
		}
		return generation;
	}

	/**
	 * get init Generation
	 * @return
	 */
	public ArrayList<BiomorphPanel> getGeneration() {
		
		return generation;
	}

	public DNAFactory() {
		// arraylist of biomorphs to be shown in GUI
		generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		// adds 9 biomorphPanels. TODO:Separate biomorph from panel?
		while (i < 9) {
			generation.add(new BiomorphPanel(i,false,10));
			i++;
		}
	}

	/**
	 * New Generation
	 */
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
