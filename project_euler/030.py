"""
Surprisingly there are only three numbers that can be written as the sum of
    fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers
    of their digits.
"""
from itertools import product
from time import time


def problema(n):
    """
    Input
    n - maxim number of digits that can produce this result
    """
    suma = 0
    b = {}
    for i in product(range(10), repeat=n):
        aux = reduce(lambda x, y: 10*x + y, i)
        b[aux] = sum(map(lambda x: x**5, i))
        if aux == b[aux]:
            suma += aux
            print aux, suma
    return suma - 1  # because the grader (and the example) does not accept 1

if __name__ == "__main__":
    start = time()
    print(problema(6))
    t = time() - start
    print t
