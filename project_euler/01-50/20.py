import time 

start = time.time()

def fact(n):
    f = 1
    while n > 0:
        f *= n
        n -= 1
    return f

suma = 0
res =  fact(100)
for i in str(res):
    suma += int(i)

# print(res)
print(suma)
print("Tiempo = {:.5f} seg".format(time.time() - start))

# 648
# Tiempo = 0.00040 seg
648
Tiempo = 0.00040 seg