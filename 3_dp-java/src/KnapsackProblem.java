import java.util.Arrays;
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
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < weightBound; j++) {
				DP_table[i][j] = (i == 0)? 0: ((weights[i] > weightBound)? DP_table[i-1][j]:
					Math.max(DP_table[i-1][j], DP_table[i-1][weightBound-j] + values[i]));
			}
		}
		
		return DP_table;
	}
	
	/* HELPER METHODS */
	public String toString() {
		return Arrays.toString(values) + 
				"\n" + Arrays.toString(weights) + " (bound: " + weightBound + ")";
	}
}
