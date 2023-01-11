import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * Here tests will be added for the algorithm implemented
 * to calculate the levenshtein distance.
 */

public class LevenshteinDistanceTest {
	@Test
	public void testCalcLevenshteinDistance() {
		LevenshteinDistance test1 = new LevenshteinDistance("TIGER", "ZIEGE");
		assertEquals(3, test1.calcLevenshteinDistance());
	}
}
