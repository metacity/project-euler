#include <iostream>
#include <cstdlib>
#include <ctime>
#include <bitset>
#include <vector>
using namespace std;

int findSecondShortest(const bitset<10000000>& rope) {
	vector<int> lengths;
	int shortest = rope.size();
	int s = rope.size();
	int prevCut = 0;
	for (int i = 0; i <= s; ++i) {
		if (i == s || rope[i]) {
			int length = i - prevCut;
			lengths.push_back(length);
			prevCut = i;
			if (length < shortest)
				shortest = length;
			//cout << shortest << endl;
		}
	}

	int secondShortest = rope.size();
	vector<int>::const_iterator end = lengths.end();
	for (vector<int>::const_iterator it = lengths.begin(); it != end; ++it) {
		if (*it >= shortest && *it <= secondShortest) {
			secondShortest = *it;
		}
	}
//	cout << secondShortest << endl;
	return secondShortest;
}

int main(int argc, char* argv[]) {
	int ropeL = 10000000;
	int points = 100;

	int iterations = 100;
	if (argc > 1)
		iterations = atoi(argv[1]);

//	vector<bool> rope(ropeL);
	bitset<10000000> rope;
	int secondShortestLength = 0;

	srand(time(0));

	for (int i = 0; i < iterations; ++i) {
		for (int j = 0; j < points - 2; ++j) {
			int cutPoint = rand() % (ropeL-1) + 1;
			cout << cutPoint << endl;
			if (rope[cutPoint])
				--j;
			else
				rope[cutPoint] = 1;
		}
		secondShortestLength += findSecondShortest(rope);
		//cout << secondShortestLength << endl;
		rope.reset();
//		rope.clear();
//		rope.resize(ropeL);
	}

	cout << 1.0 * secondShortestLength / iterations << endl;
	return 0;
}
