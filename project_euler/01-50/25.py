import time

start = time.time()
        

def fib():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b

f = fib()
for i in range(10000):
    d = next(f)
    if len(str(d)) == 1000:
        print(i)
        break

print("t = {:.5f} seg".format(time.time() - start))
    
# 4782
# t = 0.03068 seg
10
print(len(str(10)))
# 2