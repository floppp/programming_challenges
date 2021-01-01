from numpy import sqrt

N = 10
l_ciclo = 1

# for i in xrange(1, 10 + 1):
for i in range(2, N + 1):
    cadena = str(1 / i).split('0.')[1]
    if len(cadena) > 10:
    #   while j < len(cadena):
        if cadena[:l_ciclo + inc] == cadena[l_ciclo + inc:2 * (l_ciclo + inc)]:
            print(cadena)
            print(cadena[:l_ciclo], cadena[l_ciclo:2 * l_ciclo])
