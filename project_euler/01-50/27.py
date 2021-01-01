from timeit import timeit
from math import sqrt
from itertools import combinations_with_replacement

es_primo = lambda n: all(n % i != 0 for i in range(2, int(sqrt(n) + 1)))
f = lambda n, a, b: n ** 2 + a * n + b

N = 100
C = 1000
a = range(-C, C + 1)  # Al hacer una combinacion a partir de a, al ser b
# igual, no hace falta definirlo.
# a = b = range(-1000, 1001)


def func_base(n):
    count = 0
    for i in range(n):
        if es_primo(f(i, -79, 1601)):
            count += 1
        else:
            return count
    return count


def func(n, lst):
    count_max = 0
    par = []
    for i in combinations_with_replacement(lst, 2):
        count = 0
        for j in range(n + 1):
            aux = f(j, i[0], i[1])
            if aux > 0 and es_primo(aux):
                count += 1
            else:
                if count > count_max:
                    #print("a = {:4d} - b = {:4d} - n ={:4d} - primos consecutivos = {:4d}".format(i[0], i[1], j, count))
                    count_max = count
                    par = list(i)
                break
    return count_max, par

#print(func(N, a))


# Medimos tiempos
def wrapper(func_base, *args, **kwargs):
    def wrapped():
        return func(*args, **kwargs)
    return wrapped

wrapped = wrapper(func, N, a)
veces = 1
print("{:.5f} seg por loop".format(timeit(wrapped, number=veces) / veces))

# con pypy bastante mejor que con cpython, aprox mitad de tiempo (algo mejor)
