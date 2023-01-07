/*
	Author: Mattia
	Date: 04.01.23

	Implementation of the Karatsuba and Ofman algorithm.
	TODO: handle numbers, which don't have the same amount of digits
*/

#include <iostream>
#include <cstdlib>
#include <cmath>

int multiplication_counter;

int karatsubaOfmanAlgorithm(int x, int y)
{
	int total = 0, a = 0, b = 0, c = 0, d = 0;

	int partitionX = int(log10(x) + 1) / 2;
	int partitionY = int(log10(y) + 1) / 2;
	if ((partitionX == 0 || x < 0) && (partitionY == 0 || y < 0)) {
		multiplication_counter++;
		return x * y;
	} else if (x == 0 || y == 0) {
		return 0;
	} else if ((partitionX == 1 || (x < 0 && x > -10)) && (partitionY == 0 || (y < 0 && y > -10))) {
		multiplication_counter++;
		return (x/10 * 10*y + x%10 * y);
	} else if ((partitionX == 0 || (x < 0 && x > -10)) && (partitionY == 1 || (y < 0 && y > -10))) {
		multiplication_counter++;
		return (y/10 * 10*x + y%10 * x);
	}

	int p = pow(10, partitionX);

	a = x / p;
	b = x % p;

	c = y / p;
	d = y % p;

	int ac = karatsubaOfmanAlgorithm(a, c);
	int bd = karatsubaOfmanAlgorithm(b, d);
	return (100*ac + 10*ac + 10*bd + bd + 10*karatsubaOfmanAlgorithm((a-b), (d-c)));
}

int main(int argc, char **argv)
{
	if (argc != 3)
		return -1;
	multiplication_counter = 0;
	std::cout << argv[1] << " * " << argv[2] << " = " << karatsubaOfmanAlgorithm(atoi(argv[1]), atoi(argv[2])) << std::endl;
	std::cout << multiplication_counter << " multiplications, instead of " << int(log10(atoi(argv[1])) + 1)*int(log10(atoi(argv[2])) + 1) << std::endl;
	return 0;
}