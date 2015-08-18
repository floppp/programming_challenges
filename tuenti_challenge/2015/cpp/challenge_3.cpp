#include <iostream>
#include <vector>

#include "../headers/primes.hpp"

using std::cout;  using std::cin;  using std::endl;

int main()
{
  uint32_t n_cases;
  cin >> n_cases;

  std::vector<std::pair<uint32_t, uint32_t>> cases;
  std::pair<uint32_t, uint32_t> pair;
  uint64_t number_year;

  while (cin >> pair.first >> pair.second)
    cases.push_back(pair);

  std::vector<uint32_t> primes;
  primes::simple_sieve(100000, primes);

  cout << "Number of cases: " << n_cases << endl;
  for_each (cases.begin(), cases.end(), [](std::pair<uint32_t, uint32_t> p)
  {
    cout << p.first << ' ' << p.second << endl;
  });


  for (int i =)

  return 0;
}