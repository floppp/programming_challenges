#include "../headers/primes.hpp"

using std::cout;  using std::endl;

namespace primes
{
  // USING MAP INSTEAD OF VECTOR<BOOL> OR SOMETHING LIKE THAT IT'S TOO MUCH
  // EXPENSIVE. I NEED TO CHANGE THIS.
  std::map<uint32_t, bool> create_map(uint32_t const L, uint32_t const R)
  {
    std::map<uint32_t, bool> map;
    uint32_t aux = (L == 1) ? 3 : L;

    for (uint32_t i = aux; i < R; ++i)
    {
      if (i%2 != 0)
        map.insert(std::pair<uint32_t, bool>(i, true));
    }

    return map;
  }

  void sieve_erat(uint32_t const L, uint32_t const R, std::vector<uint32_t>& v)
  {
    uint32_t N = R - L + 1;
    uint32_t limit = (int) (std::sqrt(R) + 1);

    std::map<uint32_t, bool> primes = create_map(L, R);

    typedef std::map<uint32_t, bool>::iterator iter;
    iter it = primes.begin();

    if (v.size() == 0)
    {
      for (; it->first < limit; ++it)
      {
        if (it->second)
        {
          uint32_t ini = it->first * it->first;
          for (uint32_t j = ini; j < R; j += it->first)
            primes[j] = false;
        }
      }
    } else
    {
      typedef std::vector<uint32_t>::iterator v_iter;

      v_iter iter = v.begin();

      cout << "Iteration" << endl;
      // Taking the last prime we probe in the last segmentation. An optimal way could be tracing
      // this index in a variable per reference, and using that index for taking the last prime used.
      // Easy to implement (i think)
      uint32_t idx = 1;
      for (; v[idx] < limit; idx++);
      --idx;

      for (; *iter < limit; ++iter)
      {
        uint32_t init = *iter * v[idx];
        for (uint32_t i = init; i < R; i += *iter)
          primes[i] = false;
      }
    }

    // Adding only new primes
    for (iter i = primes.begin(); i != primes.end(); ++i)
      if (i->second)
        v.push_back(i->first);
  }

  std::vector<uint32_t> segmented_sieve(uint32_t const L, uint32_t const R, uint32_t const I)
  {
    std::vector<uint32_t> result;

    if (R-L <= I)
      sieve_erat(L, R, result);
    else
    {
      uint32_t idx = L;
      while (L+idx < R)
      {
        sieve_erat(idx, idx+I, result);
        idx += I;
      }
    }

    // Adding the 2. Ugly, but easiest way.
    std::vector<uint32_t>::iterator it = result.begin();
    result.insert(it, 2);

    return result;
  }
}
