'''
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

1: 1
3: 1,3
6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.
What is the value of the first triangle number to have over five hundred divisors?
'''
import cython  # Su uso no mejora al trabajar sobretodo con listas. Hay que pasarlas a listas
               # de C mediante gestion dinamica para aprovecharlo realmente

from math import sqrt
import time, timeit

@cython.locals(i=cython.int)
def divisores(numero):
    a = [i for i in range(1, numero // 2 + 1) if not numero % i]
    a.append(numero)
    return a

# Hacer esto asi y no con sum(lista) es infinitamente mas rapido
@cython.cfunc
@cython.returns(cython.int)
@cython.locals(numero=cython.int)
def numero_divisores(numero):
    return sum(2 for i in range(1, int(sqrt(numero)) + 1) if not numero % i)
    
@cython.cfunc
@cython.returns(cython.int)
@cython.locals(i=cython.int)
def gen_triangular():
    for i in range(1000000):
        yield sum(range(i))

@cython.cfunc
@cython.returns(cython.int)
@cython.locals(i=cython.int)
def main():
    for i in generador:
        if numero_divisores(i) > 500:
            return i

inicio = time.time()

generador = gen_triangular()

print("El primer numero triangular con mas de 500 divisores es {}".format(main()))
print("Tiempo: {:.5f} segundos".format(time.time() - inicio))

# Sin cython: 6.50812 segundos
# El primer numero triangular con mas de 500 divisor es 76576500
# Tiempo: 6.56195 segundos