package Stage2;

import java.util.ArrayList;
import java.util.List;
	/**
	 * Class responsible for holding the information dictating how the biomorph is drawn. E.g. face size, number of points/edges, eye number, eye position, horn appearance, mouth size, etc. Think of more features.
	 * @author Josh Merritt
	 */


public class DNA {
	
	String dna;
	
	public DNA(ArrayList<Integer> head, ArrayList<Integer> eyes, ArrayList<Integer> eyebrows, ArrayList<Integer> nose){
		
		//each value should be 3 numbers, e.g. 000-999. 0s may need removing
		
		//points, width, height
		for (int value : head){
			dna.concat(Integer.toString(value));
		}
		//width, height, points, xDistance
		for (int value : eyes){
			dna.concat(Integer.toString(value));
		}
		//width, height, distance
		for (int value : eyebrows){
			dna.concat(Integer.toString(value));
		}
		//yOffset, length, rise, height
		for (int value : nose){
			dna.concat(Integer.toString(value));
		}
	}
	
	public int[] getHeadAttribs(){
		int[] result = new int[2];
		String[] value = dna.split("");
		int i = 0;
		while (i < 3){
			result[i]= Integer.parseInt(value[i]);
			i++;
		}
		return result;
	}
	
	public int[] getEyeAttribs(){
		int[] result = new int[3];
		String[] value = dna.split("");
		int i = 3;
		while (i < 7){
			result[i]= Integer.parseInt(value[i]);
			i++;
		}
		return result;
	}
	
	public int[] getEyebrowAttribs(){
		int[] result = new int[2];
		String[] value = dna.split("");
		int i = 7;
		while (i < 10){
			result[i]= Integer.parseInt(value[i]);
			i++;
		}
		return result;
	}
	
	public int[] getNoseAttribs(){
		int[] result = new int[3];
		String[] value = dna.split("");
		int i = 10;
		while (i < 14){
			result[i]= Integer.parseInt(value[i]);
			i++;
		}
		return result;
	}
	
	public String toString(){
		return dna;
	}
	
}