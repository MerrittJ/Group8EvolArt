package Stage2;

import java.util.ArrayList;

/**
 * Class responsible for main gui.
 * @author Josh
 */
public class Control {

	private ArrayList<BiomorphPanel> generation;
	
	public Control() {
		
		//arraylist of biomorphs to be shown in GUI
		generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		//adds 9 biomorphPanels
		while (i < 9){
			generation.add(new BiomorphPanel(i,false,10));
			i++;
		}
	}
	
	public ArrayList<BiomorphPanel> getGeneration(){
		return generation;
	}

}
