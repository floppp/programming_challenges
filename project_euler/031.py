'''
In England the currency is made up of pound, £, and pence, p,
and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?
'''
COINS = (1, 2, 5, 10, 20, 50, 100, 200)
GOAL = 200


def main():
    count = 0
    for i in range(len(COINS)-1, 0, -1):
        a = COINS[i]
        for j in range(i-1, 0, -1):
            b = COINS[j]
            for k in range(j-1, 0, -1):
                c = COINS[k]
                for l in range(k-1, 0, -1):
                    d = COINS[l]
                    for m in range(l-1, 0, -1):
                        e = COINS[m]
                        for n in range(m-1, 0, -1):
                            f = COINS[n]
                            for o in range(n-1, 0, -1):
                                g = COINS[o]
                                for p in range(o-1, -1, -1):
                                    h = COINS[p]
                                    print (a, b, c, d, e, f, g, h)


if __name__ == "__main__":
    main()
