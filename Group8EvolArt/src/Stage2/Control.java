package Stage2;

import java.util.ArrayList;

public class Control {

	private ArrayList<BiomorphPanel> generation;
	
	public Control() {
		
		//arraylist of biomorphs to be shown in GUI
		generation = new ArrayList<BiomorphPanel>();
		int i = 0;
		//adds 9 biomorphPanels. TODO:Separate biomorph from panel?
		while (i < 9){
			generation.add(new BiomorphPanel(i,false,10));
			i++;
		}
	}
	
	public ArrayList<BiomorphPanel> getGeneration(){
		return generation;
	}

}
