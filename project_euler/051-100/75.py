'''
It turns out that 12 cm is the smallest length of wire that can be bent to
form an integer sided right angle triangle in exactly one way, but there are
many more examples.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an
integer sided right angle triangle, and other lengths allow more than one
solution to be found; for example, using 120 cm it is possible to form
exactly three different
integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L ≤ 1,500,000
can exactly one integer sided right angle triangle be formed?
'''
from time import time
from math import sqrt


def find_sides(l):
    o = c = h = 0
    hay_resultado = False
    for i in range(l//2 - 1, l//3, -1):
        h = i
        hs = i ** 2
        limit = (l - h) // 2
        for j in range(i - 1, limit, -1):
            o = j
            os = j ** 2
            c = l - h - o
            cs = c ** 2
            if cs + os == hs:
                if hay_resultado:
                    return False
                hay_resultado = True
    if hay_resultado:
        return 1
    return 0


def pytagoric_triplet(l):
    a = b = c = 0
    n = int(sqrt(l)) + 1
    m = 2*n / 3
    for i in range(1, m):
        for j in range(i+1, n):
            if a + b + c != l:
                a = j*j - i*i
                b = 2*j*i
                c = j*j + i*i
            else:
                return 1
    return 0


if __name__ == "__main__":
    start = time()
    res = 0
    N = 150000
    pytagoric_triplet(36)
    for i in range(2, N+1):
        res += pytagoric_triplet(i)
    print res, 'ternas primitivas'
    # for i in range(2, N+1, 2):
    #     res += find_sides(i)
    # print res
    print 'total time =', (time() - start), 's'
