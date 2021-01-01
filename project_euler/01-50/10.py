'''
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
'''
import time
from numpy import sqrt


def primos(n_max):
    for i in range(3, n_max + 1, 2):
        for j in range(3, int(sqrt(i)) + 1, 2):
            if i % j == 0: break
        else:
            yield i
                
n = 1
p = primos(3000000)
a = 0
suma = 2
t0 = time.clock()
while a < 2000000:
    n += 1
    #if n < 10: print(a)
    #if n % 10000 == 0:
    #    print("iteraciones: {} - primo: {} - suma: {}".format(n, a, suma))
    suma += a
    a = next(p)
print("iteraciones: {} - primo: {} - suma: {}".format(n, a, suma))
    
print("La suma es {}".format(suma))
print("Tiempo transcurrido = {:.3f} seg".format(time.clock() - t0))

# RESPUESTA: 142913828922  -  t: 9.377 seg
# iteraciones: 148934 - primo: 2000003 - suma: 142913828922
# La suma es 142913828922
# Tiempo transcurrido = 9.377 seg