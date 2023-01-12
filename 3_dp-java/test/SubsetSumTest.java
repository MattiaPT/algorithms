import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 12.01.23
 * 
 * Here tests will be added for the algorithm implemented
 * to calculate a solution for the subset sum problem.
 */

public class SubsetSumTest {
	@Test
	public void testCalcSubsetSum() {
		SubsetSum test1 = new SubsetSum(new int[] {3, 9, 2, 1, 8, 7, 12, 3, 15});
		boolean[][] dp_table = test1.calcSubsetSum();
		
		assertEquals(true, test1.evenSplitIsPossible(dp_table));
		int[][] solutions = test1.readSolution(dp_table);
		int[][] ideal = new int[][] {new int[] {15, 3, 12, 0, 0, 0, 0, 0, 0, 0}, new int[] {7, 8, 1, 2, 9, 3, 0, 0, 0, 0}};
		for (int i = 0; i < solutions[0].length; i++) {
			assertEquals(solutions[0][i], ideal[0][i]);
			assertEquals(solutions[1][i], ideal[1][i]);
		}
	}
}
