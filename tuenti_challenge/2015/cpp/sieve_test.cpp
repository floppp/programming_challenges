#include <vector>
#include <iostream>
#include <cstdint>

#include "./headers/primes.hpp"

using std::cout;  using std::endl;

template<class T> void print_vector(std::vector<T>);

int main()
{
  uint32_t L = 1;
  uint32_t R = 100000000;
  uint32_t I = 25;

  // std::vector<uint32_t> primes = primes::segmented_sieve(L, R);
  cout << "RESULTS\n-------" << endl;
	// for_each(primes.begin(), primes.end(), [](uint32_t p) { cout << p << ' '; });

  std::vector<uint32_t> primes = primes::simple_sieve(R);
  // print_vector(primes);
  cout << endl;
}


template<class T>
void print_vector(std::vector<T> v)
{
  for_each (v.begin(), v.end(), [](T e) { cout << e << ' ';} );
  cout << endl;
}

