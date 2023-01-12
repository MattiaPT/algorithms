import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 12.01.23
 * 
 * In this class an algorithm treating the
 * subset sum problem is implemented.
 */

public class SubsetSum {
	public static void main(String[] args) {
		SubsetSum s = new SubsetSum(new int[] {12, 3, 9, 2, 1, 8, 5});
		boolean[][] table = s.calcSubsetSum();
		

		
		int[][] t = s.readSolution(table);
	}
	
	int[] array;
	
	/* CONSTRUCTORS */
	public SubsetSum(int[] array) {
		this.array = array;
	}
	
	public boolean[][] calcSubsetSum() {
		int z = calcZ();
		boolean[][] DP_table = new boolean[array.length][z];
		for (int j = 0; j < z; j++)
			DP_table[0][j] = (j == 0);
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < z; j++)
				DP_table[i][j] = (j < array[i])? DP_table[i-1][j]: (DP_table[i-1][j] || DP_table[i-1][j-array[i]]);
		}
		return DP_table;
	}
	public int calcZ() {
		double sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i]/2;
		return (int) sum;
	}
	
	public boolean evenSplitIsPossible(boolean[][] DP_table) {
		return DP_table[DP_table.length - 1][DP_table[0].length - 1];
	}
	public int[][] readSolution(boolean[][] DP_table) {
		if (!this.evenSplitIsPossible(DP_table))
			return null;
		int[][] split = new int[2][DP_table.length];
		int pointer0 = 0, pointer1 = 0;
		
		int[] curr = new int[] {DP_table.length - 1, DP_table[0].length - 1};
		for (int i = DP_table.length - 1; i >= 0; i--) {
			if (curr[0] == 0 && curr[1] == 0)
				break;
			if (DP_table[curr[0]][curr[1]] == DP_table[curr[0] - 1][curr[1]]) {
				split[0][pointer0++] = array[i];
				curr[0]--;
			} else {
				split[1][pointer1++] = array[i];
				curr[0]--;
				curr[1] -= array[i];
			}
		}
		return split;
	}
}
