#include <string>
#include <iostream>
#include <cstdint>
#include <fstream>
#include <vector>

#include "./headers/primes.hpp"

using std::vector;  using std::cout; 
using std::string;  using std::endl;


int main()
{
	string line;
	std::ifstream file;
	uint32_t N = 1000000;

	file.open("./data/testInput_2.txt");

	if (file.is_open())
	{
		while (std::getline(file, line))
		{
			cout << line << endl;
		}
  	file.close();
	}
 
  vector<uint32_t> primes = primes::sieve_erat(N);
  // for_each (primes.begin(), primes.end(), [](uint32_t p)
  //     { cout << p << endl; });


	return 0;
}