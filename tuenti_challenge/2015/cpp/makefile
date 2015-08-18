CXX = g++
CXXFLAGS = --std=c++11 -Isources/ -Iheaders/

TARGET = challenge_3
BUIDIR = obj/
VPATH = sources/:headers/

$(TARGET):	challenge_3.cpp primes.o
	$(CXX) $(CXXFLAGS) $^ -o $@

primes.o: primes.cpp
	$(CXX) $(CXXFLAGS) -c $^

clean:
	rm -f $(TARGET) *.o
