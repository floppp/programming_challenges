import itertools
import time


start = time.time()

p = [i for i in range(1, 5)]
c = [i for i in range(1, 7)]
dic_p = {i: 0 for i in range(9, 37)}
dic_c = {i: 0 for i in range(6, 37)}

for i in itertools.product(p, repeat=9):
    dic_p[sum(i)] += 1
for i in itertools.product(c, repeat=6):
    dic_c[sum(i)] += 1

total_combination = 4**9 * 6**6 * 1.0
total_beat = 0

for i in range(9, 37):
    for j in range(6, i):
        total_beat += dic_p[i] * dic_c[j]

print(total_beat, total_combination)
print(total_beat / total_combination)
print('total time = {:.7f}'.format(time.time() - start))
