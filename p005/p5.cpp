#include <iostream>

using namespace std;

bool isDivisible(int n) {
	for (int j = 11; j < 21; ++j) {
		if (n % j != 0)
			return false;
	}
	return true;
}

int main() {
	for (unsigned int i = 1; i < 4000000000; ++i) {
		if (isDivisible(i)) {
			cout << i << endl;
			break;
		}
	}
	
	return 0;
}