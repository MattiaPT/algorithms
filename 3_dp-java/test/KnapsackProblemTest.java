import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 18.01.23
 * 
 * This class implements tests for
 * the knapsack problem.
 */
public class KnapsackProblemTest {
	@Test
	public void testdpAlgorithm() {
		KnapsackProblem test1 = new KnapsackProblem(new int[] {100, 1, 50, 50}, new int[] {101, 90, 5, 5}, 100);
		int[][] dp = test1.dpAlgorithm();
		for (int[] arr : dp)
			System.out.println(Arrays.toString(arr));
		// solution should be 101
	}
}
