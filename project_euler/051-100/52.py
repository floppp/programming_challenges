def check(n, m):
    bs = list(str(n))
    bs.sort()
    cs = list(str(m))
    cs.sort()
    return cs == bs


def main():
    k = 2
    for i in range(1, 10000000):
        k = 2
        while check(i, k * i):
            k += 1
            if k == 6:
                return i
a = main()
for i in range(1, 7):
    print(i * a)
