import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
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
		PastureBreak example1 = new PastureBreak(7);
		assertEquals(91, example1.naiveApproach());
	}
	@Test
	public void testIdealApproach() {
		PastureBreak example1 = new PastureBreak(7);
		assertEquals(37, example1.idealApproach());
	}
}
