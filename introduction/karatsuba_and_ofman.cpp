/*
	Author: Mattia
	Date: 04.01.23

	Implementation of the Karatsuba and Ofman algorithm.
	TODO: handle numbers, which don't have the same amount of digits
*/

#include <iostream>
#include <cstdlib>
#include <cmath>

int karatsubaOfmanAlgorithm(int x, int y)
{
	int total = 0, a = 0, b = 0, c = 0, d = 0;

	int partition = int(log10(x) + 1) / 2;
	if (partition == 0 && int(log10(y) + 1) == 1)
		return x * y;
	int p = pow(10, partition);

	a = x / p;
	b = x % p;

	c = y / p;
	d = y % p;

	int ac = karatsubaOfmanAlgorithm(a, c);
	int bd = karatsubaOfmanAlgorithm(b, d);
	return (100*ac + 10*ac + 10*bd + bd + 10*(a-b)*(d-c));
}

int main(int argc, char **argv)
{
	if (argc != 3)
		return -1;
	std::cout << karatsubaOfmanAlgorithm(atoi(argv[1]), atoi(argv[2])) << std::endl;
	return 0;
}