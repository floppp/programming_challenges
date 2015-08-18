#include <string>
#include <iostream>
#include <cstdint>
#include <fstream>
#include <vector>
#include <set>

#include "./headers/primes.hpp"

using std::vector;  using std::cout;  using std::cin;
using std::string;  using std::endl;

template<class T> void print_vector(vector<T>);
void almost_primes(uint32_t const, uint32_t const, vector<uint32_t> const);

int main()
{
  vector<std::pair<uint32_t, uint32_t>> extremes;
  std::pair<uint32_t, uint32_t> pairs;
  uint32_t max = 0;

  // cout << "YOU NEED TO PASS DATA FROM BASH... < data/testInput_2.txt" << endl;
  // Erasing first line with number of tests.
  cin >> pairs.first;

  // Working with stdout instead of files; assuming text file is correct.
  while (cin >> pairs.first >> pairs.second)
    extremes.push_back(pairs);

  for (std::pair<uint32_t, uint32_t> pair: extremes)
    if (pair.second > max)
      max = pair.second;

  vector<uint32_t> primes;
  primes::simple_sieve(max, primes);

  for (std::pair<uint32_t, uint32_t> pair: extremes)
  {
    // cout << "Calculating primes between " << pair.first << " and " << pair.second << endl;
    // cout << "\tnumber of primes: " << primes.size() << " under " << pair.second << endl;
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
  std::set<uint32_t> almost;
  uint32_t len = primes.size();
  uint32_t aux = 0;

  for (uint32_t i = 0; i < len && primes[i] < R; ++i)
  {
    for (uint32_t j = i; primes[j] < R; ++j)
    {
      aux = primes[i] * primes[j];
      if (aux > R)
        break;
      else if (aux < L)
        continue;

      almost.insert(aux);
      // if (almost.size() == 0)
      // {
      //   cout << "i: " << i << " - j: " << j << endl;
      //   cout << primes[i] << " * " << primes[j] << endl;
      //   cout << "multiplicacion: " << aux << endl;
      // }
    }
  }

  cout << almost.size() << endl;
}
