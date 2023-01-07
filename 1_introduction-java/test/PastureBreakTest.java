import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Author: Mattia
 * Date: 05.01.23
 * 
 * Here tests will be added for the different pasture break algorithms.
 */

public class PastureBreakTest {
	
	@Test
	public void testNaiveApproach() {
		PastureBreak test1 = new PastureBreak(7);
		assertEquals(91, test1.naiveApproach());
	}
	@Test
	public void testIdealApproach() {
		PastureBreak test1 = new PastureBreak(7);
		assertEquals(37, test1.idealApproach());
	}
}
