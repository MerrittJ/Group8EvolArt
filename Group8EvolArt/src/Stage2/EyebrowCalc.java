package Stage2;

public class EyebrowCalc {

	private int eyebrowWidth;
	private int eyebrowHeight;
	
	public EyebrowCalc() {
		
	}
	
	public void setAttribs(String[] attribs){
		eyebrowWidth = Integer.parseInt(attribs[0]);
		eyebrowHeight = Integer.parseInt(attribs[1]);
	}
	
	public int getHeadWidth() {
		return eyebrowWidth;
	}
	
	public int getHeadHeight() {
		return eyebrowHeight;
	}
}