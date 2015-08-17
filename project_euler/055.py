from time import time


def sum_reverse(n):
    return n + int(str(n)[::-1])


def is_palindrome(n):
    return str(n) == str(n)[::-1]


def main(n, l):
    res = 0
    for idx in range(n):
        z = 0
        m = idx
        while z < l:
            m = sum_reverse(m)
            z += 1
            if is_palindrome(m):
                break
        if not is_palindrome(m):
            print(idx, z, m)
            res += 1
        # else:
        #     print(idx, z, m)
    return res

if __name__ == "__main__":
    start = time()
    N = 10000
    LIMIT = 50
    print(main(N, LIMIT))
    print(time() - start, 's')
