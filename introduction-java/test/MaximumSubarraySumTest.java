import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * Here tests will be added for the different maximum subarray sum algorithms.
 */

public class MaximumSubarraySumTest {
	@Test
	public void testGetMaximumSubarraySum() {
		MaximumSubarraySum test1 = new MaximumSubarraySum(new int[] {123, -42, 9, -1, 2, 0, 32, -99, 190});
		assertEquals(214, test1.getMaximumSubarraySum());
		
		MaximumSubarraySum test2 = new MaximumSubarraySum(new int[] {-1, -2, 8, -1, 3, -7});
		assertEquals(10, test2.getMaximumSubarraySum());
	}
}
