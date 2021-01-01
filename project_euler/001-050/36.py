# The decimal number, 585 = 10010010012 (binary),
# is palindromic in both bases.
# Find the sum of all numbers, less than one million, which
# are palindromic in base 10 and base 2.
# (Please note that the palindromic number,
# in either base, may not include leading zeros.)


def problema36(n):
    suma = 0

    def is_palindrom(x): return str(x) == str(x)[::-1]
    for i in range(n):
        i_base2 = bin(i)
        if is_palindrom(i) and is_palindrom(i_base2[2:]):
            suma += i
    return suma

if __name__ == "__main__":
    maximo = 1000000
    print(problema36(maximo))
