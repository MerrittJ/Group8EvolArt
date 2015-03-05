package Stage2;

public class HeadCalc {

	// temporary values for testing purposes
	private int headLines = 4;
	private int headWidth = 200;
	private int headHeight = 200;
	
	public HeadCalc() {
		
	}
	
	public void setAttribs(String[] attribs){
		headLines = Integer.parseInt(attribs[0]);
		headWidth = Integer.parseInt(attribs[1]);
		headHeight = Integer.parseInt(attribs[2]);
	}
	
	public int getHeadLines() {
		return headLines;
	}
	
	public int getHeadWidth() {
		return headWidth;
	}
	
	public int getHeadHeight() {
		return headHeight;
	}
}
