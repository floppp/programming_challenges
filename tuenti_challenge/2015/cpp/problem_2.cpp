#include <string>
#include <iostream>
#include <cstdint>
#include <fstream>
#include <vector>
#include <map>

#include "./headers/primes.hpp"

using std::vector;  using std::cout;  using std::cin;
using std::string;  using std::endl;

template<class T> void print_vector(vector<T>);

int main()
{
  std::map<uint32_t, uint32_t> extremes;
  std::pair<uint32_t, uint32_t> pairs;
  vector<uint32_t> primes;

  // Erasing first line with number of tests.
  cin >> pairs.first;

  // Working with stdout instead of files; assuming text file is correct.
  while (cin >> pairs.first >> pairs.second)
    extremes.insert(pairs);

  for (std::pair<uint32_t, uint32_t> pair: extremes)
  {
    cout << "Calculating primes between " << pair.first << " and " << pair.second << endl;
    primes = primes::segmented_sieve(pair.first, pair.second);
    // print_vector(primes);
  }

	return 0;
}

template<class T>
void print_vector(vector<T> v)
{
  for_each (v.begin(), v.end(), [](T e) { cout << e << ' ';} );
  cout << endl;
}


