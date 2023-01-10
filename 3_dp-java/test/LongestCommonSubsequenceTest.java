import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 09.01.23
 * 
 * Here tests will be added for the algorithm implemented
 * to calculate longest common subsequence.
 */

public class LongestCommonSubsequenceTest {
	@Test
	public void testCalcLCS() {
		LongestCommonSubsequence test1 = new LongestCommonSubsequence("TIGER", "ZIEGE");
		assertEquals(3, test1.calcLCS());
	}
}
