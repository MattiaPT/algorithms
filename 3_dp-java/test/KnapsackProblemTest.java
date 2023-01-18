import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

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
		KnapsackProblem test1 = new KnapsackProblem(new int[] {100, 1, 59, 41}, new int[] {102, 90, 5, 5}, 101);
		int[][] dp1 = test1.dpAlgorithm();
		assertEquals(101, test1.readSolution(dp1));
		Map<Integer, Integer> solution = new HashMap<>();
		solution.put(1, 90);
		solution.put(41, 5);
		solution.put(59, 5);
		assertEquals(true, solution.equals(test1.backtrackSolution(dp1)));
		System.out.println(test1.backtrackSolution(dp1));

		KnapsackProblem test2 = new KnapsackProblem(new int[] {100, 1, 59, 41}, new int[] {101, 90, 5, 5}, 100);
		int[][] dp2 = test2.dpAlgorithm();
		assertEquals(101, test2.readSolution(dp2));
		assertEquals(true, solution.equals(test1.backtrackSolution(dp2)));
	}
}
