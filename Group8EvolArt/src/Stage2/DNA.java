package Stage2;

import java.util.ArrayList;
import java.util.List;
	/**
	 * Class responsible for holding the information dictating how the biomorph is drawn. E.g. face size, number of points/edges, eye number, eye position, horn appearance, mouth size, etc. Think of more features.
	 * @author Josh Merritt
	 */


public class DNA {
	
	List<String> dna = new ArrayList<String>(); //collection for DNA, containing eyebrowHeightDNA, eyebrowWidthDNA
	private int eyebrowHeight; 
	private String eyebrowHeightDNA = "AAT"; //DNA for eyebrowHeight set as AAT. When height is 1, DNA for eyebrow is AAT. When height is 2, DNA is AATAAT
	
	private int eyebrowWidth; 
	private String eyebrowWidthDNA = "AAC"; 
	
	private int eyebrowThickness;
	private String eyebrowThicknessDNA = "AAG";
	
	/**
	 * Constructor accepting one parent's DNA to use and mutate
	 */
	public DNA(int factInput) {
		//dna = Integer.toString(factInput).split("");
	}

	public ArrayList<Integer> getFace(){
		ArrayList<Integer> faceAttribs = new ArrayList<Integer>();
		int noOfFaceAttribs = 1;
		int i = 0;
		while (i < noOfFaceAttribs){
			//faceAttribs.add((Integer.parseInt(dna[i])));
		}
		return null;
	}
	
	//set the eyebrow height
	public void setEyebrowHeight( int height){ 
		height = eyebrowHeight;
		
	}
	
	
	//set the eyebrow width
	public void setEyebrowWidth( int width){ 
		width = eyebrowWidth;
		
	}
	
	//set the eyebrow weight
	public void setEyebrowThickness( int weight){ 
		weight = eyebrowThickness;
		
	}
	
	//Store the eyebrow height DNA sequence into the DNA collection
	public void setEyebrowHeightDNA(){  
		int i =0;
		while(i<eyebrowHeight){
			eyebrowHeightDNA.concat("AAT"); //add "AAT" onto the original eyebrow height DNA 
			i++;
			}
			dna.add(eyebrowHeightDNA); // add the final eyebrowHeightDNA to the collection DNA
		}
	
	//Store the eyebrow width DNA sequence into the DNA collection
	public void setEyebrowWidthDNA(){  //Store all the different gene DNA into the DNA collection
		int i =0;
		while(i<eyebrowWidth){
			eyebrowWidthDNA.concat("AAC"); //add "AAC" onto the original eyebrow width DNA string
			i++;
			}
			dna.add(eyebrowWidthDNA); // add the final eyebrowWidthDNA to the collection DNA
		}
	
		
	//Store the eyebrow weight DNA sequence into the DNA collection
	public void setEyebrowThicknessDNA(){  //Store all the different gene DNA into the DNA collection
		int i =0;
		while(i<eyebrowThickness){
			eyebrowThicknessDNA.concat("AAG"); //add "AAG" onto the original eyebrow width DNA string
			i++;
			}
			dna.add(eyebrowThicknessDNA); // add the final eyebrowWidthDNA to the collection DNA
		}
	
	
	}



