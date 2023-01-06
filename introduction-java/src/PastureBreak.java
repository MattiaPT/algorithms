import java.util.Random;
import java.lang.Math;

/*
 * Author: Mattia
 * Date: 05.01.23
 * 
 * This class should realize a numerical implementation
 * for the pasture break problem:
 *  - starting position: 0
 */


public class PastureBreak {
	private int pastureBreakPosition;
	
	public PastureBreak() {
		this.pastureBreakPosition = (new Random()).nextInt(20) - 10;
	}
	public PastureBreak(int pastureBreakPosition) {
		this.pastureBreakPosition = pastureBreakPosition;
	}
	
	public int naiveApproach() {
		/* one step left, one step right, ... */
		int totalSteps = 0, current = 0;
		while (current != pastureBreakPosition) {
			totalSteps += Math.abs(current)*2 + ((current <= 0)? 1: 0);
			current = -current + ((current <= 0)? 1: 0);
		}
		return totalSteps;
	}
	
	public int idealApproach() {
		int totalSteps = 0, current = 0, i = 0, drop;
		while (true) {
			while (Math.abs(current) < Math.pow(2, i)) {
				totalSteps++;
				drop = (i%2 == 0)? current++: current--;
				if (current == pastureBreakPosition)
					return totalSteps;
			}
			i++;
		}
	}
	
	public int getPastureBreakPosition() {
		return pastureBreakPosition;
	}
}
