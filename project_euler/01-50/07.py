'''
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can 
see that the 6th prime is 13.

What is the 10 001st prime number?
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
p = primos(100000000)

t0 = time.clock()
while n < 100001:
    a = next(p)
    n += 1

print("El primo {} es {}".format(n, a))
print("Tiempo transcurrido = {:.3f} seg".format(time.clock() - t0))

# El primo 100001 es 1299721
# Tiempo transcurrido = 6.070 seg
