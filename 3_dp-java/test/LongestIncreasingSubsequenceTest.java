import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 09.01.23
 * 
 * Here tests will be added for the algorithm implemented
 * to calculate longest increasing subsequences.
 */

public class LongestIncreasingSubsequenceTest {
	@Test
	public void testCalcLIS() {
		LongestIncreasingSubsequence test1 = new LongestIncreasingSubsequence(new int[] {1, 4, 6, 3, 5, 7, 9, 8});
		assertEquals(5, test1.calcLIS());
	}
}
