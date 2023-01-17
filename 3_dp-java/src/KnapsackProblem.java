import java.util.Arrays;

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
	
	private int totalWeight;
	
	/* CONSTRUCTORS */
	public KnapsackProblem(int[] values, int[] weights) {
		this.values = values;
		this.weights = weights;
		calcTotalWeight();
	}
	
	public int[] dpAlgorithm() {
		/* TODO */
		return null;
	}
	
	/* HELPER METHODS */
	public void calcTotalWeight() {
		totalWeight = 0;
		for (int i = 0; i < weights.length; i++)
			totalWeight += weights[i];
	}
	public String toString() {
		return Arrays.toString(values) + 
				"\n" + Arrays.toString(weights) + " (total: " + totalWeight + ")";
	}
}
