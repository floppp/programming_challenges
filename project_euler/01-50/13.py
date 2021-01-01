'''
Work out the first ten digits of the sum of
the following one-hundred 50-digit numbers.
'''
r = open('./numero_ejercicio_13.txt')
s = 0
for i in r:
    s += int(i)
print(s)
