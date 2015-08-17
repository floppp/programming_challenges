from math import sqrt
from timeit import timeit


def sieve(N):
    ''' Sieve of Eratosthenes with no segmentation '''
    cand = [(idx % 2 != 0) for idx in range(N)]
    rango = [i for i in range(3, int(sqrt(N)) + 1, 2) if cand[i]]
    for i in rango:
        if cand[i]:
            for j in range(i * i, N, i):
                cand[j] = False
    return [idx for idx, j in enumerate(cand) if j]


def wrapper(function, *args, **kwargs):
    def wrapped():
        return function(*args, **kwargs)
    return wrapped


if __name__ == "__main__":
    N = 1000000
    rep = 10
    wrapped = wrapper(sieve, N)
    print("{:.5f} seg por loop".format(timeit(wrapped, number=rep) / rep))
    # print("resultado:\n{}".format(sieve(N)))
