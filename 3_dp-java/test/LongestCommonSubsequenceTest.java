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
		
		LongestCommonSubsequence test2 = new LongestCommonSubsequence("SCHOGGI", "CHOITSCHGI");
		assertEquals(4, test2.calcLCS());
		
		LongestCommonSubsequence test3 = new LongestCommonSubsequence("", "EMPTY");
		assertEquals(0, test3.calcLCS());
	}
}
