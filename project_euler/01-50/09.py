'''
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000. 
Find the product abc.

Para n > m > 0:

a = n^2 - m^2

b = 2nm

c = n^2 + m^2

a, b, c son terna
'''

import time

def triplete_base(num):
    for n in range(25):
        for m in range(n):
            a = n**2 - m**2
            b = 2 * n * m
            c = n**2 + m**2
            if a + b + c == num:
                return "{} * {} * {} = {}".format(a, b, c, a*b*c)           

start = time.time()
# for i in range(100):
print(triplete_base(1000))
print("Tiempo total {} seg".format(time.time() - start))

# 375 * 200 * 425 = 31875000
# Tiempo total 0.0008294582366943359 seg

# Muy pitonico, mas lento (el doble aprox)
import time

def triplete(num):
    return [[(n**2 - m**2, 2*m*n, n**2 + m**2) for m in range(1, n) if (n**2 - m**2 + 2*m*n + n**2 + m**2) == 1000] for n in range(1, 25)]

start = time.time()
# for i in range(100):
triplete(1000)
print("Tiempo total {} seg".format(time.time() - start))

# Tiempo total 0.001071929931640625 seg


for i in range(10):
    t1 = time.clock()
    triplete_base(1000)
    print(time.clock() - t1)
print("------")
for i in range(10):
    t1 = time.clock()
    triplete(1000)
    print(time.clock() - t1)

# 0.0002599999999972624
# 0.0004559999999997899
# 0.0004930000000058499
# 0.0004729999999995016
# 0.0004930000000058499
# 0.00047399999999697684
# 0.00047399999999697684
# 0.0004540000000048394
# 0.00048300000000267573
# 0.0004989999999907013
# ------
# 0.0007220000000103255
# 0.0006529999999997926
# 0.0007109999999954653
# 0.0007580000000046994
# 0.00041899999999372994
# 0.00039799999998990643
# 0.0003889999999984184
# 0.0003930000000025302
# 0.0003659999999996444
# 0.0004729999999995016
