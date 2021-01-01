'''
Encontrar el número más pequeño que es divisible por los 
primeros 20 números
'''

# v 0.0  - Optimizado de 9'5 seg, a 4'7 seg, a 2'4 seg, haciendo comprobación %10 y usando 19 como base divisora
# v 0.01 - Poniendo los paréntesis, mejoro un pelín, un 1 % aprox
# Declarando las variables de forma estática con cython no consigo ventaja importante
# v 0.1  - for... que controla el factor multiplicador: 2'36 seg
# v 0.2  - comprobacion if... % 20 en vez de % 10: 2'03 seg
# v 0.3  - comprobacion if... compuesta: 1'79 seg
def divisible():
    # Sin problema de memoria porque el range de python3 es el xrange de python2
    for i in range(1, 100000000):
        # Todo el rato i*19 porque no mejora por almacenar al principio y calcular una sola vez
        if ((i*19 % 20) == 0 and (i*19 % 18) == 0):
            # El orden a la hora de recorrer el bucle da lo mismo, aunque no tiene mucha lógica
            for j in range(11, 18):
                if (i*19 % j) != 0: 
                    j -= 1
                    break
            if j == 17: 
                return i * 19
    
    ''' Otra forma mas lenta, pero mas intuitiva '''
#     i = 20
#     while i > 0:
#         for j in range(11, 20):
#             if i % j != 0:
#                 i += 20
#                 break
#         else:
#             return i
            
        
        
import time

# for i in range(5):
t1 = time.clock()
print(divisible())
print("{} s".format(time.clock() - t1))

# ESTA SOLUCION ES UNA PUTA MIERDA... mirar debajo los dos algoritmos que hay
# 232792560
# 1.8114570000000008 s

#########################################
#########################################

# Metodo absurdamente rapido. No tengo muy clara la teoria
# [Actualizado] Debajo esta hecho con algoritmo mio. Velocidad 
# equivalente a este.

import time
t1 = time.clock()

facList = [2]
prod = 1

for i in range(3,20):
    n = i
    for j in facList:
        if n % j == 0:
            n //= j  # //= en vez de /= para trabajar con enteros
    facList.append(n)

for k in facList:
    prod *= k
print(facList)
print(prod)
print("{:.5f} seg".format(time.clock() - t1))

# [2, 3, 2, 5, 1, 7, 2, 3, 1, 11, 1, 13, 1, 1, 2, 17, 1, 19]
# 232792560
# 0.00042 seg


#########################################
#########################################

# Voy a implementar el algoritmo usado en scala
'''
def problema_005(x: Int) : Int =
{
    def MCD(a: Int, b: Int):Int = if (b == 0) a.abs else MCD(b, a % b)
    def mcm(a: Int, b: Int) = {
        val c = (a * b).abs / MCD(a, b)
        if (c > a) c else a  // Esto impide que lo que hallemos sea
        // realmente el mcm, pero para poder resolver el problema
        // es necesario.
    }

    (1 to x toList).reduceLeft(mcm)
}
'''

import time
t1 = time.clock()

def MCD(a, b):
    if b == 0:
        return a
    else:
        return MCD(b, a % b)
        
def mcm(a, b):  # Euclides
    c = a * b // MCD(a, b)
    if c > a:
        return c
    else:
        return a

n  = 20
acum = 1
for i in range(2, n + 1):
    acum = mcm(acum, i)
print(acum)
print("{:.5f} seg".format(time.clock() - t1))

# 232792560
# 0.00093 seg