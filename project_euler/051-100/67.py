'''IGUAL QUE EL 18'''

import time

start = time.time()

num_int = []
# numbers = open('problem18.txt')
numbers = open('problem67.txt')
# Creamos matriz con enteros
for i in numbers:
    num_int.append([int(j) for j in i.split()])
a = [[int(j) for j in i] for i in numbers]
def camino(lista):
    n = lista[::-1]
    while len(n) > 0:
        j = 0
        while j < (len(n[0]) - 1):
            n[1][j] += max(n[0][j], n[0][j + 1])
            j += 1
        aux = n.pop(0)
    return aux
        
        
print(camino(num_int))
print("Tiempo = {:.5f} seg".format(time.time() - start))

# [7273]
# Tiempo = 0.00553 seg
# No hago mas pruebas porque me ha salido eficiente de cojones
[7273]
Tiempo = 0.00553 seg
