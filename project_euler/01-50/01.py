# Suma de múltiplos de 3 o 5 menores de 1000.
from numpy import *

a = linspace(1, 999, 999)
b = [x for x in a if x % 3 == 0 or x % 5 == 0]
sum(b)

# 233168.0