package Stage2;

import java.util.ArrayList;
import java.util.Random;

public class DNAFactory {

	//private Mutator mutator; Singleton Mutator here?
	private Random random = new Random(); 
	
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
	
	public DNA generateDNA() {
		DNA dna; 
		
		
		ArrayList<Integer> head = new ArrayList<>();
		ArrayList<Integer> eyes = new ArrayList<>();
		ArrayList<Integer> eyebrows = new ArrayList<>();
		ArrayList<Integer> nose = new ArrayList<>();
		
		head.add(random.nextInt(999)+1);
		head.add(random.nextInt(999)+1);
		head.add(random.nextInt(999)+1);
		
		eyes.add(random.nextInt(999)+1);
		eyes.add(random.nextInt(999)+1);
		eyes.add(random.nextInt(999)+1);
		
		eyebrows.add(random.nextInt(999)+1);
		eyebrows.add(random.nextInt(999)+1);
		eyebrows.add(random.nextInt(999)+1);
		
		nose.add(random.nextInt(999)+1);
		nose.add(random.nextInt(999)+1);
		nose.add(random.nextInt(999)+1);
		
		dna = new DNA(head, eyes, eyebrows, nose);
		
		return dna;
	}

}