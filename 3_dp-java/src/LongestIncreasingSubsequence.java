
public class LongestIncreasingSubsequence {
	private int[] array;
	
	/* CONSTRUCTORS */
	public LongestIncreasingSubsequence(int[] array) {
		this.array = array;
	}
	
	public int calcLIS() {
		int[] DP_table = new int[array.length];
		DP_table[0] = array[0];
		int index = 1;
arrayLoop:
		for (int i = 1; i < array.length; i++) {
			for (int j = index - 1; j >= 0; j++) {
				if (DP_table[j] > array[i]) {
					DP_table[j] = array[i];
					index = index + ((j == index - 1)? 1: 0);
					continue arrayLoop;
				}
			}
		}
		return index;
	}
}
