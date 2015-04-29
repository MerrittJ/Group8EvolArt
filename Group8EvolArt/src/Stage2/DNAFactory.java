package Stage2;

import java.util.ArrayList;
import java.util.Random;
/**
 * Class responsible for generating unique biomorphs to begin the evolutionary process with and to continue it.
 * @author Mohammed Baseel, Sheraz Atiq, Aman Kauldhar 
 */
public class DNAFactory {

	private Random random = new Random();
	/**
	 * ArrayList holding the next generation of biomorphs to be sent to the GUI
	 */
	private ArrayList<BiomorphPanel> generation;
	
	 /**
	  * Method to return a generation of biomorphs. This generation is derived from selected biomorphs from the previous one.
	  * @param biomorf1Code Integer referring to which biomorph was selected out of the 9 of the previous generation
	  * @return an ArrayList of 9 biomorphs as the next generation
	  */
	public ArrayList<BiomorphPanel> getGeneration(int biomorf1Code) {
		ArrayList<BiomorphPanel> generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		while (i < 9) {
				generation.add(new BiomorphPanel(i,true,biomorf1Code));
			i++;
		}
		return generation;
	}

	/**
	 * Method to return the generation of biomorphs stored in the DNAFactory
	 * @return
	 */
	public ArrayList<BiomorphPanel> getGeneration() {
		
		return generation;
	}

	/**
	 * Constructor for DNAFactory. On instantiation, it will create a generation of biomorphs from scratch and store it in the field.
	 */
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
}
