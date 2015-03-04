package Stage2;

import java.util.ArrayList;
	/**
	 * Class responsible for holding the information dictating how the biomorph is drawn. E.g. face size, number of points/edges, eye number, eye position, horn appearance, mouth size, etc. Think of more features.
	 * @author Josh Merritt
	 */
public class DNA {
	
	private String[] dna;
	
	/**
	 * Constructor accepting one parent's DNA to use and mutate
	 */
	public DNA(int factInput) {
		dna = Integer.toString(factInput).split("");
	}

	public ArrayList<Integer> getFace(){
		ArrayList<Integer> faceAttribs = new ArrayList<Integer>();
		int noOfFaceAttribs = 1;
		int i = 0;
		while (i < noOfFaceAttribs){
			faceAttribs.add((Integer.parseInt(dna[i])));
		}
		return null;
	}
}
