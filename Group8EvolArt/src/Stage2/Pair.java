package Stage2;

/**
 * A simple class to hold two (and only two) objects of any type. Useful for coordinates and pairs of objects (e.g. biomorph eyes)
 * @author Josh Merritt
 */
public class Pair<X, Y> {
	public X x;
	public Y y;

	/**
	 * Empty constructor
	 */
	public Pair(){
	}
	
	/**
	 * Constructor allowing immediate declaration of variables X and Y
	 */
	public Pair(X x, Y y){
		this.x = x;
		this.y = y;
	}
}
