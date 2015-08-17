def fact(n, acum):
    if n == 1:
        return acum
    else:
        return fact(n-1, acum*n)


def fact_iter(n):
    fact = 1
    while n > 1:
        fact *= n
        n -= 1
    return fact


def combinatoric(n, r):
    return fact_iter(n)/(fact_iter(r)*fact_iter(n-r))


def function(min, max):
    count = 0
    for i in range(23, max+1):
        for j in range(1, i+1):
            if combinatoric(i, j) > 1000000:
                print "n:", i, "r:", j
                count += 1
    return count


if __name__ == "__main__":
    print function(23, 100)
