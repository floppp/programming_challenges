"""
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
"""
import time, timeit

def suma_digitos(base=2, exp=1):
    suma = 0
    res = str(base**exp)
    for i in range(len(res)):
        suma += int(res[i])
    return suma

start = time.time()

print(suma_digitos(2, 1000))
print("tiempo = {:.5f} seg".format(time.time() - start))
# 1366
# tiempo = 0.00025 seg
