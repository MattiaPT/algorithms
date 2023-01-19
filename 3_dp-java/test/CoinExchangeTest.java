import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 19.01.23
 * 
 * This class implements tests for 
 * the implemented coin exchange algorithms.
 */

public class CoinExchangeTest {
	@Test
	public void testdpAlgorithm() {
		CoinExchange test1 = new CoinExchange(new int[] {1, 2, 5});
		int[][] dp = test1.dpAlgorithm(5);
		for (int[] arr : dp)
			System.out.println(Arrays.toString(arr));
		System.out.println(test1.extractResult(dp));
	}
}
