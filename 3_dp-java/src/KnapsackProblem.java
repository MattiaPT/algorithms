import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;


/*
 * Author: Mattia
 * Date: 17.01.23
 * 
 * In this class an algorithm treating 
 * the knapsack problem is implemented.
 */

public class KnapsackProblem {
	private int[] values;
	private int[] weights;
	
	private int weightBound;
	
	/* CONSTRUCTORS */
	public KnapsackProblem(int[] values, int[] weights, int weightBound) {
		this.values = values;
		this.weights = weights;
		this.weightBound = weightBound;
	}
	
	public int[][] dpAlgorithm() {
		int[][] DP_table = new int[values.length+1][weightBound+1];
		for (int i = 0; i <= values.length; i++) {
			for (int j = 0; j <= weightBound; j++) {
				DP_table[i][j] = (i == 0)? ((j == 0)? 0: Integer.MIN_VALUE):
					((weights[i-1] > j)? DP_table[i-1][j]:
					Math.max(DP_table[i-1][j], DP_table[i-1][j-weights[i-1]] + values[i-1]));
			}
		}
		return DP_table;
	}
	public int[] getPositionOfSolution(int[][] DP_table) {
		if (DP_table[DP_table.length-1][DP_table[DP_table.length-1].length-1] > 0)
			return new int[] {DP_table.length-1, DP_table[DP_table.length-1].length-1};
		// thus, there was no "perfect match" for weight bound
		int[] max = new int[2];
		for (int i = 0; i < DP_table[DP_table.length-1].length; i++) {
			if (DP_table[max[0]][max[1]] < DP_table[DP_table.length-1][i])
				max = new int[] {DP_table.length-1, i};
		}
		return max;
	}
	public int readSolution(int[][] DP_table) {
		int[] position = getPositionOfSolution(DP_table);
		return DP_table[position[0]][position[1]];
	}
	public Map<Integer, Integer> backtrackSolution(int[][] DP_table) {
		int[] position = getPositionOfSolution(DP_table);
		int i = position[0], j = position[1];
		Map<Integer, Integer> solution = new HashMap<Integer, Integer>();
		while (i != 0 && j != 0) {
			if (j >= weights[i-1] && DP_table[i][j] - values[i-1] == DP_table[i-1][j - weights[i-1]]) {
				solution.put(values[i-1], weights[i-1]);
				j -= weights[i-1];
			}
			i--;
		}
		return solution;
	}
	
	/* HELPER METHODS */
	public String toString() {
		return Arrays.toString(values) + 
				"\n" + Arrays.toString(weights) + " (bound: " + weightBound + ")";
	}
}
