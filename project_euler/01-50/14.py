## VERSION RECURSIVA SIN MEJORAS
#  Tiempo: 55.16645 segundos (con operacion binaria aprox lo mismo)
#  Resultado 837.799

import time

def collatz(n, lista):
    lista.append(n)
    if n == 1:
        return 1, lista
    elif n % 2:
        return collatz(int(n*3 + 1), lista)
    else:
        return collatz(n >> 1, lista)
    
start = time.time()
max_len = max_num = 0
lista = []
for i in range(1, 27):
    lista = collatz(i, [])[1]
    length = len(lista)
    if length > max_len:
        max_len = length
        max_num = i
print("La cadena del numero {} tiene {} elementos".format(max_num, max_len))
print("Tiempo: {:.5f} segundos".format(time.time() - start))
# La cadena del numero 25 tiene 24 elementos
# Tiempo: 0.00043 segundos

## VERSION RECURSIVA - CONTADOR EN VEZ DE LISTA
#  Tiempo: 46.91166 segundos; MEJOR que con listas
#  Resultado 837.799

import time

def collatz(n, count):
    count += 1
    if n == 1:
        return 1, count
    elif n % 2:
        return collatz(int(n*3 + 1), count)
    else:
        return collatz(n >> 1, count)
    
start = time.time()
max_len = max_num = 0
length = 0
for i in range(1, 10000):
    length = collatz(i, 0)[1]
    if length > max_len:
        max_len = length
        max_num = i
print("La cadena del numero {} tiene {} elementos".format(max_num, max_len))
print("Tiempo: {:.5f} segundos".format(time.time() - start))
La cadena del numero 6171 tiene 262 elementos
Tiempo: 0.30881 segundos
## VERSION ITERATIVA SIN MEJORAS
#  Tiempo: 25.73280 segundos; MEJOR que recursivas
#  Resultado 837.799

import time

def collatz(n):
    count = 1  # Para contar el propio 1
    while n > 1:
        if n % 2:
            n = 3*n + 1
        else:
            n = n >> 1
        count += 1
    return n, count
    
start = time.time()
max_len = max_num = 0
for i in range(1, 100000):
    num, length = collatz(i)
    if length > max_len:
        max_len = length
        max_num = i
print("La cadena del numero {} tiene {} elementos".format(max_num, max_len))
print("Tiempo: {:.5f} segundos".format(time.time() - start))
# La cadena del numero 77031 tiene 351 elementos
# Tiempo: 2.09933 segundos
# %load_ext cythonmagic

# %%cython

## VERSION ITERATIVA CYTHON
#  Tiempo: 15.87660 segundos; MEJOR que recursivas
#  Resultado 837.799 - 525 elementos
#  Con declaraciones -> 14.21716 segundos

import time

# import numpy as np
# cimport numpy as np
cimport cython

@cython.cfunc
@cython.cdivision(True)  # Directiva a true para evitar comprobaciones
# @cython.locals(n=cython.int) ## no puedo ponerlo porque se ralla
@cython.locals(count=cython.int)
def collatz(n):
#     count = cython.declare(cython.int, 1)  # Para contar el propio 1
    count = 1
    while n > 1:
        if n % 2:
            n = 3*n + 1
        else:
            n = n >> 1
        count += 1
    return n, count

@cython.cdivision(True)
def main():
    # DECLARACIONES
    cdef int max_len, max_num, num, length
    start   = cython.declare(cython.double, time.time())
    max_len = 0
    for i in range(1, 300000):
        num, length = collatz(i)
        if length > max_len:
            max_len = length
            max_num = i
    print("La cadena del numero {} tiene {} elementos".format(max_num, max_len))
    print("Tiempo: {:.5f} segundos".format(time.time() - start))

main()
# La cadena del numero 230631 tiene 443 elementos
# Tiempo: 3.88586 segundos

# %%cython

## VERSION ITERATIVA CYTHON - CON CACHE
#  Tiempo: 1.50683 segundos; MEJORA enorme
#  Resultado 837.799 - 525 elementos

import time

# import numpy as np
# cimport numpy as np
cimport cython

CACHE = {}

@cython.cfunc
@cython.cdivision(True)  # Directiva a true para evitar comprobaciones
# @cython.locals(n=cython.int) ## no puedo ponerlo porque se ralla
@cython.locals(count=cython.int)
def collatz(n):
    global CACHE
    CACHE[1] = 1
    CACHE[2] = 2
    count, aux = 0, n
#     aux = n
    while n > 1:
        if n in CACHE:
            count += CACHE[n]
            CACHE[aux] = count
            return n, count
        else:
            if n % 2:
                n = 3*n + 1
            else:
                n = n >> 1
        count += 1
    CACHE[aux] = count
    return n, count

@cython.cdivision(True)
def main2():
    # DECLARACIONES
    cdef int max_len, max_num, num, length
    start   = cython.declare(cython.double, time.time())
    max_len = 0
    for i in range(2, 1000000):
        num, length = collatz(i)
        if length > max_len:
            max_len = length
            max_num = i
    print("La cadena del numero {} tiene {} elementos".format(max_num, max_len))
    print("Tiempo: {:.5f} segundos".format(time.time() - start))

main2()
# La cadena del numero 837799 tiene 525 elementos
# Tiempo: 1.50683 segundos
