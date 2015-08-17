CXX = g++
CXXFLAGS = --std=c++11 -Isources/ -Iheaders/

TARGET = sieve
VPATH = sources/:headers/

$(TARGET): sieve_test.cpp primes.o
	$(CXX) $(CXXFLAGS) $^ -o $@

primes.o: primes.cpp
	$(CXX) $(CXXFLAGS) -c $^

clean:
	rm -f $(TARGET) *.o
