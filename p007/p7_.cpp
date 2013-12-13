/* Nopea seula! */

#include <iostream>
#include <vector>

using namespace std;

vector<unsigned int> givePrimes(unsigned int n) {
        vector<unsigned int> primes;
        vector<bool> arePrimes(n + 1, true);

        for (unsigned int i = 2; i < n + 1; ++i) {
                if (arePrimes[i]) {
                        primes.push_back(i);
                        for (unsigned int j = 2 * i; j < n + 1; j += i) {
                                arePrimes[j] = false;
                        }
                }
        }

        return primes;
}

int main() {
        unsigned int n;
        cout << "Primes between 1-N. Give N: ";
        cin >> n;

        vector<unsigned int> primes = givePrimes(n);
        for (unsigned int i = 0; i < primes.size() && i < 10002; ++i) {
                cout << i+1 << ": " << primes[i] << endl;
				
        }

        return 0;
}
