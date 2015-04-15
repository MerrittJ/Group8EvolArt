package Stage2;

import java.util.ArrayList;
import java.util.Random;

public class DNAFactory {

	//private Mutator mutator; Singleton Mutator here?
	private Random random = new Random(); 
	
	public DNAFactory() {
		
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