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
void almost_primes(uint32_t const, uint32_t const, vector<uint32_t> const);

int main()
{
  std::map<uint32_t, uint32_t> extremes;
  std::pair<uint32_t, uint32_t> pairs;

  // cout << "YOU NEED TO PASS DATA FROM BASH... < data/testInput_2.txt" << endl;
  // Erasing first line with number of tests.
  cin >> pairs.first;

  // Working with stdout instead of files; assuming text file is correct.
  while (cin >> pairs.first >> pairs.second)
    extremes.insert(pairs);

  for (std::pair<uint32_t, uint32_t> pair: extremes)
  {
    vector<uint32_t> primes;
    cout << "Calculating primes between " << pair.first << " and " << pair.second << endl;
    primes::simple_sieve(pair.second, primes);
    cout << "\tnumber of primes: " << primes.size() << endl;
    almost_primes(pair.first, pair.second, primes);
  }

	return 0;
}

template<class T>
void print_vector(vector<T> v)
{
  for_each (v.begin(), v.end(), [](T e) { cout << e << ' ';} );
  cout << endl;
}

void almost_primes(uint32_t const L, uint32_t const R, vector<uint32_t> const primes)
{
  uint32_t len = primes.size();
  uint32_t count = 0;
  uint32_t aux = 0;

  // while (primes[i] < L)
    // ++i;
  // cout << i << ' ' << primes[i] << endl;

  for (uint32_t i = 0; i < len-1; ++i)
    for (uint32_t j = i; j < len; j++)
    {
      aux = primes[i] * primes[j];
      if (aux > R)
        break;
      else if (aux < L)
        continue;
      count++;
    }
  cout << count << endl;
}
