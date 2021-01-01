"""
A perfect number is a number for which the sum of its proper divisors is
exactly equal to the number. For example, the sum of the proper divisors
of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
number.

A number n is called deficient if the sum of its proper divisors is less
than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24. By
mathematical analysis, it can be shown that all integers greater than 28123
can be written as the sum of two abundant numbers. However, this upper
limit cannot be reduced any further by analysis even though it is known that
the greatest number that cannot be expressed as the sum of two abundant
numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum
of two abundant numbers.
"""

import time
from itertools import combinations_with_replacement
import numpy


# Forma correcta de hacerlo, increiblemente mas eficiente que las
# anteriores (que son la misma de dos formas distintas)
def divisores_tres(n):
    divi = [1]
    s = 1
    fin = int(numpy.sqrt(n))
    if fin * fin == n:
        divi.append(fin)
        s = 0
    for i in range(2, fin + s):
        if n % i == 0:
            divi.append(i)
            divi.append(n // i)

    return divi


def numeros_abundantes(n):
    f = lambda x: sum(divisores_tres(x)) > x
    return [i for i in range(2, n + 1) if f(i)]

N = 28123
start = time.time()


## Aqui es donde pierdo el tiempo. Pero tambien es dificil
## mejorar, los dos bucles son distintos (el primero es enoooorme)
suma_abundantes = [False] * (2 * N + 1)
a = numeros_abundantes(N)
for i in combinations_with_replacement(a, 2):
    suma_abundantes[sum(i)] = True

print(sum(i for i in range(1, N + 1) if not suma_abundantes[i]))

print("tiempo = {:.5f} seg".format(time.time() - start))

# 4179871
# tiempo = 7.21484 seg
