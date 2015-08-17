# The arithmetic sequence, 1487, 4817, 8147, in which each of the
# terms increases by 3330, is unusual in two ways:
#     (i) each of the three terms are prime, and,
#     (ii) each of the 4-digit numbers are permutations
#          of one another.
#
# There are no arithmetic sequences made up of three 1-, 2-,
# or 3-digit primes, exhibiting this property, but there is one
# other 4-digit increasing sequence.
#
# What 12-digit number do you form by concatenating the three
# terms in this sequence?
from math import sqrt
from itertools import permutations
from timeit import timeit


def problema049():
    """
        Metodo largo, pero facil y claro
    """
    def is_prime(x): return all(x % i != 0
                                for i in range(2, int(sqrt(x) + 1)))
    dic = {}
    for i in range(1000, 9999):
        aux = []
        todas_permutaciones = []
        if is_prime(i):
            array = [i for i in str(i)]
            # creamos array con todos los valores que se pueden
            # formar a partir del numero, ordenados, sin repetir
            for j in permutations(array):
                tmp = int(''.join(j))
                if tmp > 1000 and tmp not in todas_permutaciones:
                    todas_permutaciones.append(tmp)
            todas_permutaciones.sort()
            # Para cada serie, vemos cuantos primos hay y los
            # anyadimos.
            # Con esta list comprehension extra es mas rapido
            # (si la hago con un loop extra tambien) que si anyado
            # directamente a aux en el loop anterior. Cosas
            # de python.
            aux = [j for j in todas_permutaciones if is_prime(j)]
            # Recorremos cada serie, y si algunas restas son
            # iguales, esa es
            j = 2
            while j < len(aux):
                a = aux[j] - aux[j - 1]
                b = aux[j - 1] - aux[j - 2]
                if a == b:
                    return aux
                j += 1
            dic[i] = aux
    return -1

if __name__ == '__main__':
    # print(problema049())
    # Medimos tiempos
    def wrapper(problema049, *args, **kwargs):
        def wrapped():
            return problema049(*args, **kwargs)
        return wrapped

    wrapped = wrapper(problema049)
    veces = 100
    print("{:.5f} seg por loop".format(timeit(wrapped, number=veces) / veces))
    print("resultado: {}".format(problema049()))
# con pypy bastante mejor que con cpython, aprox mitad de tiempo (algo mejor)
