"""
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then
there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in
words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
20 letters. The use of "and" when writing out numbers is in compliance with
British usage.
"""
import time, timeit

def number_to_letter(n: "Int") -> "str":
#             1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19    
    u = [ 0,  3,  3,  5,  4,  4,  3,  5,  5,  4,  3,  6,  6,  8,  8,  7,  7,  8,  9,  8 ]
    d = [ 0,  4,  6,  6,  6,  5,  5,  7,  6,  6 ]
    c = [ 0,  7, 10, 12, 11, 11, 10, 12, 12, 11 ]
    m = [ 0, 11 ]

    suma_and = 3
    count = 0
    for i in range(n, 0, -1):
        plus = 0
        aux = i
        while i > 0:
            if i > 999:
                plus += m[1]
                i -= 1000
            elif i > 99:
                centena = int(str(i)[0])
                i -= centena * 100
                plus += c[centena] + suma_and
            elif i > 19:
                decena = int(str(i)[0])
                i -= decena * 10
                plus += d[decena]
            else:
                plus += u[i]
                i = 0
        count += plus
        
    return count

start = time.time()
respuesta = number_to_letter(1000)
print(respuesta)
print("tiempo = {:.5f} seg".format(time.time() - start))

assert respuesta == 21124
# 20951
# tiempo = 0.00302 seg
# [1;31m---------------------------------------------------------------------------[0m
# [1;31mAssertionError[0m                            Traceback (most recent call last)
# [1;32m<ipython-input-1-9ee1ed287a84>[0m in [0;36m<module>[1;34m()[0m
# [0;32m     62[0m [0mprint[0m[1;33m([0m[1;34m"tiempo = {:.5f} seg"[0m[1;33m.[0m[0mformat[0m[1;33m([0m[0mtime[0m[1;33m.[0m[0mtime[0m[1;33m([0m[1;33m)[0m [1;33m-[0m [0mstart[0m[1;33m)[0m[1;33m)[0m[1;33m[0m[0m
# [0;32m     63[0m [1;33m[0m[0m
# [1;32m---> 64[1;33m [1;32massert[0m [0mrespuesta[0m [1;33m==[0m [1;36m21124[0m[1;33m[0m[0m
# [0m
# [1;31mAssertionError[0m: 
u = [0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 8, 9, 8]
d = [0, 4, 6, 6, 6, 5, 5, 7, 6, 6]
c = [0, 10, 10, 12, 11, 11, 10, 12, 12]
## NO TENGO BIEN EL PROBLEMA
## El planteamiento si, pero hay algun numero en ingles 
## que no se escribir y me jode la cuenta.
## He buscado la solucion y la he puesto en el resultado

## no se donde fallo
