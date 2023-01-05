import java.util.Random;

/*
 * Author: Mattia
 * Date: 05.01.22
 * 
 * This class should realize a numerical implementation
 * for the star search problem
 */

public class StarSearch {
	private int groupSize;
	private int star;
	
	public StarSearch(int groupSize) {
		this.groupSize = groupSize;
		star = (new Random()).nextInt(groupSize);
	}
}
