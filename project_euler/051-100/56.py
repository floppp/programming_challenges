def digit_sum(n):
    s = 0
    while n > 9:
        s += n % 10
        n = n // 10
    s += n
    return s


maxim = 0
ini = 90
base = 99
aux = base ** ini
for j in range(ini, 100):
    aux *= base
    k = digit_sum(aux)
    if k > maxim:
        maxim = k
print(maxim)
