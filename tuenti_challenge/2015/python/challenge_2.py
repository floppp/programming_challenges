from sys import path
path.append("../libPython")
from sieve_eratosthenes import sieve
from sieve_eratosthenes import wrapper
from timeit import timeit

if __name__ == "__main__":
    N = 1000000
    rep = 10
    wrapped = wrapper(sieve, N)
    print("{:.5f} seg por loop".format(timeit(wrapped, number=rep) / rep))
    # print("resultado:\n{}".format(sieve(N)))
