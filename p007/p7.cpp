#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int k) {
	if (k <= 1)
		return false;
	if (k == 2)
		return true;
	if (k % 2 == 0)
		return false;

	int squareRoot = sqrt(k * 1.0);
	for (int i = 3; i < squareRoot; i += 2)
		if (k % i == 0)
			return false;

	return true;
}

int main() {
	int primes = 6;
	int i = 13;
	while (primes < 10001) {
		if (isPrime(++i))
			++primes;
	}
	cout << i << " " << primes << endl;
	return 0;
}