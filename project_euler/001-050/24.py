import itertools
import time

start = time.time()

a = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
count = 0
for i in itertools.permutations(a, 10):
    count +=1
    if count == 1000000:
        print(i)
        break
        
print("t = {:.5f} seg".format(time.time() - start))
# (2, 7, 8, 3, 9, 1, 5, 4, 6, 0)
# t = 0.22544 seg


## AQUI ESTA EL CODIGO DE LA FUNCION EMPLEADA DEL MODURLO itertools
def permutations(iterable, r=None):
    pool = tuple(iterable)
    n = len(pool)
    r = n if r is None else r
    if r > n:
        return
    indices = list(range(n))
    cycles = list(range(n, n-r, -1))
    yield tuple(pool[i] for i in indices[:r])
    while n:
        for i in reversed(range(r)):
            cycles[i] -= 1
            if cycles[i] == 0:
                indices[i:] = indices[i+1:] + indices[i:i+1]
                cycles[i] = n - i
            else:
                j = cycles[i]
                indices[i], indices[-j] = indices[-j], indices[i]
                yield tuple(pool[i] for i in indices[:r])
                break
        else:
            return
