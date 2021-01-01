## No hay que rellenar nada, hay que ver como evolucionan los valores en las diagonales
# Diagonal de top-left -> bottom-right
N = 1001
sum1 = 1
sumT = 1
inc = 2
for i in range(1, N):
    sum1 += inc
#     print(sum1)
    inc += 2
    sumT += sum1

print('######')
# Diagoanl de top-right -> bottom-left
sum2 = 1
inc2 = 4
for i in range(1, N):
    sum2 += inc2
#     print(sum2)
    if (i % 2 == 0):
        inc2 += 4
    sumT += sum2
    
print(sumT)

# No calculo tiempo porque es casi instantaneo
######
# 669171001
for i in a:
    print(i)
# [ 21.  22.  23.  24.  25.]
# [ 0.  2.  0.  0.  0.]
# [ 0.  0.  2.  0.  0.]
# [ 0.  0.  0.  2.  0.]
# [ 0.  0.  0.  0.  0.]