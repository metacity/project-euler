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
	if ((k + 1) % 6 != 0 && (k - 1) % 6 != 0)
		return false;

	int squareRoot = sqrt(k * 1.0);
	for (int i = 3; i < squareRoot; i += 2)
		if (k % i == 0)
			return false;

	return true;
}

int main() {
	long long int k = 600851475143LL;
	int maxFactor = 0;
	for (int i = 0; i <= k; ++i) {
		if (isPrime(i)) {
			if (k % i == 0 && i >= maxFactor) {
				maxFactor = i;
				k = k / i;
				cout << i << endl;
			}
		}
	}
	
	//cout << maxFactor << endl;
	
	return 0;
}