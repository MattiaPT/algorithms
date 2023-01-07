import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Fibonacci.*;

/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * Here tests will be added for the different algorithms implemented
 * to calculate fibonacci numbers.
 */

public class FibonacciTest {
	@Test
	public void testnthFibonacciRecursive() {
		assertEquals(1, Fibonacci.nthFibonacciRecursive(1));
		assertEquals(1, Fibonacci.nthFibonacciRecursive(2));
		
		assertEquals(55, Fibonacci.nthFibonacciRecursive(10));
		assertEquals(832040, Fibonacci.nthFibonacciRecursive(30));
	}
	
	@Test
	public void testnthFibonacciIdeal() {
		assertEquals(1, Fibonacci.nthFibonacciIdeal(1));
		assertEquals(1, Fibonacci.nthFibonacciIdeal(2));
		
		assertEquals(55, Fibonacci.nthFibonacciIdeal(10));
		assertEquals(832040, Fibonacci.nthFibonacciIdeal(30));
	}
}
