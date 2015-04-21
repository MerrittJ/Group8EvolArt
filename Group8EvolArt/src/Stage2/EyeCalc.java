package Stage2;

public class EyeCalc {

	private int eyeWidth;
	private int eyeHeight;
	
	public EyeCalc() {
		
	}
	
	public void setAttribs(String[] attribs){
		eyeWidth = Integer.parseInt(attribs[0]);
		eyeHeight = Integer.parseInt(attribs[1]);
	}
	
	public int getHeadWidth() {
		return eyeWidth;
	}
	
	public int getHeadHeight() {
		return eyeHeight;
	}
}