''' We shall say that an n-digit number is pandigital if ti makes use of all
the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital, and
it is also prime.

What is the larges n-digit pandigital prime that exists?'''

from itertools import permutations
from functools import reduce
from math import sqrt, ceil


def is_prime(x):
    if x % 2 == 0:
        return False
    for i in range(3, ceil(sqrt(x)) + 1, 2):
        # print(x, i)
        if x % i == 0:
            # print(x, i)
            return False
    return True


def find_pandigital(n):
    '''
    Function that get the maxim pandigital and prime number with n digits
    '''
    print(n)
    maxi = 0
    for i in permutations(range(1, n + 1)):
        aux = reduce(lambda x, y: 10 * x + y, i)
        # print(aux)
        if is_prime(aux) and aux > maxi:
            maxi = aux
    if maxi == 0:
        return find_pandigital(n - 1)
    else:
        return maxi


print('El numero es', find_pandigital(9))
