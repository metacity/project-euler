#include <iostream>
using namespace std;

int main() {
	int sum = 0;
	int sumOfSquares = 0;
	for (int i = 1; i < 101; ++i) {
		sumOfSquares += i * i;
		sum += i;
	}
	cout << sum * sum - sumOfSquares << endl;
	return 0;
}