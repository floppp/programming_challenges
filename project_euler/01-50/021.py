"""
Let d(n) be defined as the sum of proper divisors of n (numbers
less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an
amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10,
11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The
proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
"""


import time


def divisores(n):
    return [i for i in range(1, n // 2 + 1) if n % i == 0]


# Menos pythonico, igual de eficiente, no mejora
def divisores_2(n):
    suma = 0
    for i in range(1, n // 2 + 1):
        if n % i == 0:
            suma += i
    return suma


# Fuerza bruta O(N^2). No sirve para mas de 500 aprox
def amigos_bruta(n):
    suma = 0
    for i in range(4, n):
        sum_n1 = sum(divisores(i))
        for j in range(max(i + 1, sum_n1), n):
            sum_n2 = sum(divisores(j))
            if (sum_n1 == j and sum_n2 == i and sum_n1 > 0):
                print(i, j)
                suma += i + j
    return suma


start = time.time()


# A lo bruto pero menos. Calculo d(num) = suma para cada i
# veo si d(suma) = num
# Mucho mas rapido que el anterior, que es estupido.
# Util, los saca, hay que comprobar que la suma no se sale
# del rango, y para no repetir calculo llevo control de los
# anteriores. Con un vector caracteristico sobra para con-
# trolarlo, gastanto solo 2xn bytes
def amigos_bruta_bis(n):
    suma = 0
    numeros = [False] * (n + 1)
    for i in range(4, n):
        s = sum(divisores(i))
        if not numeros[i] and s < n:
            numeros[s] = True
            if (i == sum(divisores(s)) and i != s):
                print(i, s)
                suma += i + s
    return suma


print(amigos_bruta_bis(10000))
print("Tiempo es {:.5f} seg".format(time.time() - start))

start = time.time()

# Funcion en C# con prog func. Buenas ideas
# Func<int,int> divs = n => Enumerable.Range(1, n).Where(i => n % i == 0).
# sum();
# Func<int,int,bool> areFriends = (a,b) => a!=b && divs(a) == divs(b);

n = 1000
div = filter(lambda i, n: n % i == 0, range(1, n // 2 + 1))

amigos = lambda x, y: x != y and sum(
    divisores(x)) == y and sum(divisores(y)) == x
#print(sum(divisores(220)))
#print(sum(divisores(284)))
# suma_div = lambda x, y:
# amigos = [i for i in list(div) if ]
# print(list(div(100)))
print(amigos(220, 284))

print("Tiempo es {:.5f} seg".format(time.time() - start))
