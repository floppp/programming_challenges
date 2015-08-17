#include <vector>
#include <iostream>
#include <cstdint>

#include "./headers/primes.hpp"

using std::cout;  using std::endl;

int main()
{
  uint32_t L = 1;
  uint32_t R = 200;
  uint32_t I = 25;

  std::vector<uint32_t> primes = primes::segmented_sieve(L, R);
  cout << "RESULTS\n-------" << endl;
	for_each(primes.begin(), primes.end(), [](uint32_t p) { cout << p << ' '; });
  cout << endl;
}
