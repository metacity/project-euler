#include <iostream>
using namespace std;

int main() {
	int sum = 0;
	int fib = 1, a = 1, b = 1;
	do {
		if (fib % 2 == 0)
			sum += fib;

		fib = a + b;
		b = a;
		a = fib;
	} while (fib < 4000000);

	cout << sum << endl;
	return 0;
}
