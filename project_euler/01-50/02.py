'''
Each new term in the Fibonacci sequence is generated by 
adding the previous two terms. By starting with 1 and 2,
the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose
values do not exceed four million, find the sum of the
even-valued terms.
'''

import timeit

def fibonacci(a):
    fib = []
    b, c = 0, 1
    while c < a:
        fib.append(c)
        b, c = c, b + c
        
    return fib

sum([x for x in fibonacci(4000000) if x % 2 == 0])
# %timeit fibonacci(100)
def main():
    fibonacci(100)
# t = timeit.repeat(for x in range(100): fibonacci(100))
timeit.timeit(main, number=100)