import java.lang.Math;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * In this class an algorithm for the calculation
 * of the levenshtein distance is implemented.
 */

public class LevenshteinDistance {
	private String string1;
	private String string2;
	
	/* CONSTRUCTORS */
	public LevenshteinDistance(String string1, String string2) {
		this.string1 = string1;
		this.string2 = string2;
	}
	
	public int calcLevenshteinDistance() {
		int[][] DP_table = new int[string2.length()][string1.length()];
		for (int i = 0; i < string2.length(); i++) {
			for (int j = 0; j < string1.length(); j++) {
				DP_table[i][j] = Math.min(
						Math.min((i == 0)? 1: DP_table[i - 1][j] + 1, (j == 0)? 1: DP_table[i][j - 1] + 1),
						(i == 0 || j == 0)? 1: DP_table[i - 1][j - 1] + (string2.charAt(i) == string1.charAt(j)? 0: 1));
			}
		}
		return DP_table[string2.length() - 1][string1.length() - 1];
	}
}
