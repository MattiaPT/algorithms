
/*
 * Author: Mattia
 * Date: 19.01.23
 * 
 * In this class an algorithm treating 
 * the coin exchange problem is implemented.
 */

public class CoinExchange {
	private int[] coinValues;
	int n;
	
	/* CONSTRUCTORS */
	public CoinExchange(int[] coinValues) {
		this.coinValues = coinValues;
	}
	
	public int[][] dpAlgorithm(int n) {
		this.n = n;
		int[][] DP_table = new int[n+1][coinValues.length+1];
		for (int i = 1; i < n+1; i++)
			DP_table[i][0] = Integer.MAX_VALUE;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < coinValues.length+1; j++) {
				DP_table[i][j] = (coinValues[j-1] > i)? DP_table[i][j-1]:
					Math.min(DP_table[i][j-1], DP_table[i - coinValues[j-1]][j] + 1);
			}
		}
		
		return DP_table;
	}
	
	public int extractResult(int[][] DP_table) {
		return DP_table[n][coinValues.length];
	}
}
