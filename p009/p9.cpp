#include <iostream>
#include <cstdlib>
using namespace std;

int main() {
	for (int i = 2; i < 1001; ++i) {
		for (int j = i; j < 1001; ++j) {
			for (int k = j; k < 1001; ++k) {
				if (i*i + j*j == k*k && i+j+k == 1000) {
					cout << i << endl;
					cout << j << endl;
					cout << k << endl;
					cout << "i*j*k = " << i*j*k << endl;
					exit(0);
				}
			}
		}
	}
	return 0;
}