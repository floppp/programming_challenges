'''
The number, 197, is called a circular prime because all rotations of the
digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37,
71, 73, 79, and 97.

How many circular primes are there below one million?

'''
from math import sqrt, ceil
from time import time


def get_prime():
    n = 3
    while True:
        yield n
        n += 2
        while not is_prime(n):
            n += 2


def is_prime(n):
    if n % 2 == 0:
        return False
    for i in range(3, int(ceil(sqrt(n))) + 1):
        if n % i == 0:
            return False
    return True


def check_values(xs):
    for i in xs:
        if not is_prime(i):
            return False
    return True


def rotations(n):
    aux = str(n)
    res = []
    for i in range(len(aux)):
        res.append(int(aux[i:] + aux[:i]))
    return tuple(res)

if __name__ == "__main__":
    start = time()
    N = 1000000
    count = 1  # Para contar el 2
    gen = get_prime()
    num = next(gen)
    while num < N:
        values = rotations(num)
        if check_values(values):
            print values
            count += 1
        num = next(gen)
    print count
    print time() - start, 's'
