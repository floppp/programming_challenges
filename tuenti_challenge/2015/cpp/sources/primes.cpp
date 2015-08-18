#include "../headers/primes.hpp"

using std::cout;  using std::endl;

namespace primes
{
  void simple_sieve(uint32_t const N, std::vector<uint32_t>& v)
  {
    std::vector<bool> primes(N, true);
    uint32_t limit = (int) (std::sqrt(N) + 1);

    if (v.size() == 0)
    {
      for (uint32_t i = 3; i < limit; i += 2)
        if (primes[i])
          for (int j = i*i; j < N; j += i)
            primes[j] = false;

      v.push_back(2);
      for (uint32_t i = 3; i < N; i += 2)
        if (primes[i])
          v.push_back(i);
    }
  }
}
