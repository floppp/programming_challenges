'''
Realizar la resta entre el cuadrado de la suma de los 100 primeros numeros y 
la suma de los cuadrados\n", "de los 100 primeros numeros
'''

def cuadrado_suma(num):
    sum = (num + 1)*num / 2
    return int(sum**2)

def suma_cuadrados(num):
    return sum([x**2 for x in range(num + 1)])

num = 1000
print(cuadrado_suma(100) - suma_cuadrados(100))

# Solucion 25164150