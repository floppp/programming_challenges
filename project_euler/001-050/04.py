'''
A palindromic number reads the same both ways. The largest 
palindrome made from the product of two 2-digit numbers 
is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit
numbers.
'''
def es_palindromo(n):
    s = str(n)
    i = 0
    while i < len(s) / 2:
        if s[i] != s[-i - 1]: return False
        i += 1
    return True

def fuerza_bruta(n):
    lista = []
    for i in range(n, 900, -1):
        for j in range(n, i, -1):
            if es_palindromo(i * j):
                lista.append(i * j)
    return max(lista), lista

import time
start = time.time()
print(fuerza_bruta(999))
print("Tiempo {:.5f} seg".format(time.time() - start))

# 906609, [888888, 861168, 886688, 906609, 824428, 819918])
# Tiempo 0.00425 seg