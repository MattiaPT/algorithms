import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 08.01.23
 * 
 * In this class an algorithm for the calculation
 * of longest increasing subsequences is implemented.
 */

public class LongestIncreasingSubsequence {
	private int[] array;
	
	/* CONSTRUCTORS */
	public LongestIncreasingSubsequence(int[] array) {
		this.array = array;
	}
	
	public int calcLIS() {
		int[] DP_table = new int[array.length];
		Arrays.fill(DP_table, -1);
		DP_table[0] = array[0];
		int index = 1;
arrayLoop:
		for (int i = 1; i < array.length; i++) {
			for (int j = index; j >= 1; j--) {
				if ((DP_table[j] > array[i] || DP_table[j] == -1) && array[i] > DP_table[j - 1]) {
					DP_table[j] = array[i];
					index = index + ((j == index)? 1: 0);
					continue arrayLoop;
				}
			}
		}
		return index;
	}
}
