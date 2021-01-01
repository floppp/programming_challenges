'''
The primes 3, 7, 109, and 673, are quite remarkable. By taking
any two primes and concatenating them in any order the result
will always be prime. For example, taking 7 and 109, both 7109
and 1097 are prime. The sum of these four primes, 792, represents
the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two
primes concatenate to produce another prime.
'''
from itertools import permutations, combinations
from math import sqrt, ceil
from time import time


def main():
    primos = [i for i in range(3, 10000) if is_prime(i)]
    LEN = len(primos)
    for i in range(LEN):
        p1 = primos[i]
        for j in range(i + 1, LEN):
            p2 = primos[j]
            if not prueba_simple((p1, p2)):
                continue
            for k in range(j + 1, LEN):
                p3 = primos[k]
                if not prueba_simple((p1, p3)) or \
                   not prueba_simple((p2, p3)):
                    continue
                for l in range(k + 1, LEN):
                    p4 = primos[l]
                    if not prueba_simple((p1, p4)) or \
                       not prueba_simple((p2, p4)) or \
                       not prueba_simple((p3, p4)):
                        continue
                    for m in range(l + 1, LEN):
                        p5 = primos[m]
                        if not prueba_simple((p1, p5)) or \
                                not prueba_simple((p2, p5)) or \
                                not prueba_simple((p3, p5)) or \
                                not prueba_simple((p4, p5)):
                            continue
                        else:
                            return (p1, p2, p3, p4, p5), sum((p1, p2, p3, p4, p5))


# es_primo = lambda n: all(n % i != 0 for i in range(2, int(sqrt(n) + 1)))
def is_prime(x):
    if x % 2 == 0:
        return False
    for i in range(3, int(ceil(sqrt(x)) + 1), 2):
        if x % i == 0:
            return False
    return True


def get_prime():
    i = 3
    while True:
        if is_prime(i):
            yield i
        i += 1


def prueba_simple(xs):
    for i in permutations(xs):
        if not is_prime(reduce(lambda x, y: int(str(x) + str(y)), i)):
            return False
    return True


def contains(xs):
    for i in xs[0]:
        if i in xs[1]:
            return True
    return False


if __name__ == "__main__":
    start = time()
    print main()
    print 'total time =', (time() - start), 's'
