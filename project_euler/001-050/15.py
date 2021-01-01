## PARA RESOLVER ESTE PROBLEMA HACE FALTA TENERLO CLARO DESDE EL PRINCIPIO
## CON EL METODO DE LA ULTIMA CELDA ES INFINITAMENTE MAS FACIL Y RAPIDO

# Para entender este metodo, hay que pensar a partir de un caso base de n = 2
# y a partir de ahi ir viendo caminos posibles a cada celda desde una hipotetica
# casilla 0,0
# Al aumentar para mayores n's se sigue la misma matematica por lo que podemos
# aplicar lo hallado para n = 2. Programarlo es tremendamente facil

def lattice_paths(n: "Integer") -> "Iterable[Int]":
    camino = [[0]*(n + 1) for i in range(n + 1)]
    for row in range(n + 1):
        for col in range(n + 1):
            if row == 0 or col == 0:
                camino[row][col] = 1
            else:
                camino[row][col] = camino[row - 1][col] + camino[row][col - 1]
    return camino

start = time.time()
for i in range(100):
    lattice_paths(20)
# print("Tiempo: {:.5f} segundos".format(time.time() - start))  
# Tiempo: 0.01856 segundos

# %%

## FORMA MAS RAPIDA. COPIADA DE WEB. POCO INTUITIVA
## AUN CONSIGUE MAYOR VELOCIDAD CON CYTHON Y MALLOC

import time

def route_num(cube_size):
    L = [1] * cube_size
    for i in range(cube_size):
        for j in range(i):
            L[j] = L[j]+L[j-1]
        L[i] = 2 * L[i - 1]
    return L[cube_size - 1]
 
start = time.time()
n = route_num(20)
elapsed = (time.time() - start)
print("{} found in {} seconds".format(n,elapsed))
# 137846528820 found in 0.00013113021850585938 seconds

# %%
## Calculando factoriales (con combinatoria), mucho mas rapido
#  ( 40  20 )
import time

def combinaciones(n, k):
    n = factorial(n) / (factorial(k)*factorial(n - k))
    return int(n)

def factorial(n):
    a = 1
    while n > 1:
        a *= n
        n -= 1
    return int(a)

start = time.time()
for i in range(100):
    combinaciones(40, 20)
print("Tiempo: {:.5f} segundos".format(time.time() - start))    
# Tiempo: 0.00128 segundos
