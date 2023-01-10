import java.lang.Math;

/*
 * Author: Mattia
 * Date: 09.01.23
 * 
 * In this class an algorithm for the calculation
 * of longest common subsequence is implemented.
 */

public class LongestCommonSubsequence {
	private String string1;
	private String string2;
	
	/* CONSTRUCTORS */
	public LongestCommonSubsequence(String string1, String string2) {
		this.string1 = string1;
		this.string2 = string2;
	}
	
	/* calculate longest common subsequence (LCS) */
	public int calcLCS() {
		if (string1.equals("") || string1 == null || string2.equals("") || string2 == null)
			return 0;
		int[][] DP_table = new int[string2.length()][string1.length()];
		for (int i = 0; i < string2.length(); i++) {
			for (int j = 0; j < string1.length(); j++) {
				DP_table[i][j] = Math.max(
						Math.max((i == 0)? 0: DP_table[i-1][j], (j == 0)? 0: DP_table[i][j-1]),
						(i == 0 || j == 0)? 0: DP_table[i-1][j-1] + ((string2.charAt(i) == string1.charAt(j))? 1: 0));
			}
		}
		return DP_table[string2.length() - 1][string1.length() - 1];
	}
}
