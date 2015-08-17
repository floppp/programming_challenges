from time import time
from math import log


start = time()

file_name = 'p099_base_exp.txt'
max_base = max_exp = 0

with open(file_name, 'r') as f:
    content = [[int(number)
                for number in line.strip('\n').split(',')] for line in f]

base, _ = zip(*content)
min_base = min(base)
# content_bas_sorted = sorted(content, key=lambda x: x[0], reverse=True)

for i in range(len(content)):
    factor = log(content[i][0], min_base)
    content[i][1] *= factor

_, exponent = zip(*content)
res = max(exponent)

print res, exponent.index(res) + 1
print time() - start, 's'
