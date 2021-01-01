'''
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
'''

def primos(n_max):
    pr = [1, 2, 3]
    for i in range(4, n_max + 1):
        # LO DEJO POR CURIOSIDAD, PERO ES MÁS RÁPIDO COMPROBAR HASTA SQRT(NUM) + 1 QUE NO COMPROBAR TODOS LOS PRIMOS
        # HASTA EL NÚMERO DE ESTUDIO. LO IDEAL SERÍA COMBINAR AMBAS, PERO LO HE HECHO CON LIST COMPREHENSION CON IF
        # Y EL TRATAMIENTO DE LA LISTA LO RALENTIZA MUCHO MÁS.
        # ASÍ QUE LO MÁS RÁPIDO -> LO MENOS SOFISTICADO. 
        #
        # VER EJERCICIO 10
        for j in pr[1:]:
            if i % j == 0: break
        else:
            pr.append(i)
            yield i

from math import sqrt

def factor_primes(num):
    d = (int(sqrt(num)) + 1)
    b = primos(d)
    mult    = 1
    factors = []
    for i in b:
        if num % i == 0:
            factors.append(i)
            mult *= i
#             print("{:4d} - {:12d}".format(i, mult))
            if mult == num:
                break
    return factors

import time

t1 = time.clock()
for i in range(100):
    factor_primes(600851475143)
print("Tiempo total {} seg".format(time.clock() - t1))

# t -> 4.958 seg
# No esta optimizado, como si esta en parte el ejercicio 10.
# De todas formas, nada que hacer contra C o Scala. En este ulitmo,
# 109 ms (con mis conocimientos ridiculos).

# Tiempo total 4.958439 seg
