package Fibonacci;
/*
 * Author: Mattia
 * Date: 07.01.23
 * 
 * In this class different algorithms for the calculation
 * of fibonacci numbers are implemented.
 */

public class Fibonacci {
	
	public static int nthFibonacciRecursive(int n) {
		if (n == 2 || n == 1)
			return 1;
		return nthFibonacciRecursive(n - 1) + nthFibonacciRecursive(n - 2);
	}
	
	public static int nthFibonacciIdeal(int n) {
		int fib1 = 1, fib2 = 1, temp;
		
		for (int i = 3; i <= n; i++) {
			temp = fib2;
			fib2 = (fib1 >= temp)? fib1 + fib2: fib2;
			fib1 = (temp > fib1)? fib1 + fib2: fib1;
		}
		
		return (fib1 > fib2)? fib1: fib2;
	}
}
