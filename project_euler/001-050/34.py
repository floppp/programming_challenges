def fact(n):
  res = 1
  while n > 1:
    res *= n
    n -= 1
  return res

def find_max(n):
  return fact(n) * len(str(n))

def suma_fact_digitos(n):
  res = 0
  while n != 0:
     aux = n % 10
     res += DICT[aux]
     n = n // 10
  return res

def main():
  suma = 0
  for i in range(10, 100000):
    if i == suma_fact_digitos(i):
      suma += i
  return(suma)

from time import time
start = time()
DICT = {i: fact(i) for i in range(10)}
print(DICT)
print(main())
print(time() - start, 's')








