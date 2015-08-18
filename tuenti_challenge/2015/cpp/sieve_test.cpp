#include <vector>
#include <iostream>
#include <cstdint>
#include <chrono>

#include "./headers/primes.hpp"

using std::cout;  using std::endl;

template<class T> void print_vector(std::vector<T>);

int main()
{
  uint32_t L = 1;
  uint32_t R = 10000000;
  uint32_t I = 25;

  // std::vector<uint32_t> primes = primes::segmented_sieve(L, R);
  cout << "RESULTS\n-------" << endl;
	// for_each(primes.begin(), primes.end(), [](uint32_t p) { cout << p << ' '; });

  std::chrono::high_resolution_clock::time_point t1 = std::chrono::high_resolution_clock::now();
  for (int i = 0; i < 10; ++i)
  {
    std::vector<uint32_t> primes;
    primes::simple_sieve(R, primes);
  }
  std::chrono::high_resolution_clock::time_point t2 = std::chrono::high_resolution_clock::now();

  // print_vector(primes);
  auto duration = std::chrono::duration_cast<std::chrono::microseconds>((t2-t1)/10).count();
  cout << duration/1000 << " ms/loop" << endl;
}


template<class T>
void print_vector(std::vector<T> v)
{
  for_each (v.begin(), v.end(), [](T e) { cout << e << ' ';} );
  cout << endl;
}

