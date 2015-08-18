#ifndef _PRIMES_
#define _PRIMES_

#include <cstdint>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

#include <math.h>

using std::cout;  using std::endl;

namespace primes
{
  // void simple_sieve(uint32_t const, std::vector<uint32_t>&);
  std::vector<uint32_t> simple_sieve(uint32_t const);
  std::map<uint32_t, bool> create_map(uint32_t const, uint32_t const);
  void sieve_erat(uint32_t const, uint32_t const, std::vector<uint32_t>&);
  std::vector<uint32_t> segmented_sieve(uint32_t const, uint32_t const, uint32_t const=10000000);
}

#endif
