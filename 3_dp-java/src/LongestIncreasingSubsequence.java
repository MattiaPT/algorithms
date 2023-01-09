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
	
	/* calculate longest increasing subsequence (LIS) */
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
	
	/* calculate longest increasing subsequence using binary search */
	public int optimizedCalcLIS() {
		int[] DP_table = new int[array.length];
		Arrays.fill(DP_table, Integer.MAX_VALUE);
		DP_table[0] = array[0];
		int[] counter = new int[] {1};
		for (int i = 1; i < array.length; i++)
			DP_table[binarySearch(DP_table, array[i], counter)] = array[i];
		return counter[0];
	}
	public int binarySearch(int[] array, int value, int[] counter) {
		int left = 0, middle, right = array.length - 1;
		while (left <= right) {
			middle = (left + right) / 2;
			if ((middle == 0 || array[middle - 1] <= value) &&
					(middle == array.length - 1 || (array[middle + 1] >= value && array[middle] >= value))) {
				counter[0] = counter[0] + ((middle == counter[0])? 1: 0);
				return middle;
			} else if (middle == 0 || array[middle - 1] <= value) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return left;
	}
}
