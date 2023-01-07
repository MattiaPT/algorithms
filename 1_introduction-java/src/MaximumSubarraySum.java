/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * This class should realize a numerical implementation
 * for the maximum subarray problem.
 */

public class MaximumSubarraySum {
	private int[] data;
	
	public MaximumSubarraySum(int[] data) {
		this.data = data;
	}
	
	public int getMaximumSubarraySum() {
		int currentCounter = 0, maxCounter = 0;
		for (int i = 0; i < data.length; i++) {
			currentCounter = (currentCounter + data[i] >= 0)? currentCounter + data[i]: 0;
			maxCounter = (currentCounter > maxCounter)? currentCounter: maxCounter;			
		}
		return maxCounter;
	}
}
