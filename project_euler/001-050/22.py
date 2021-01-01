import numpy
import time

start = time.time()

def names():
    f = open("p022_names.txt", "r")
    text = f.read().split(",")
    words = []
    for i in text:
        words.append(i.replace("\"", ""))
    return sorted(words)

def value(str_list):
    sum_t = 0
    index = 0
    dict_val = { 'A': 1, 'B':2, 'C': 3, 'D': 4, 'E': 5, 'F': 6,'G': 7,'H': 8,'I': 9,'J': 10,'K': 11,'L': 12,'M': 13,'N': 14,'O': 15,'P': 16,'Q': 17,'R': 18,'S': 19,'T': 20,'U': 21,'V': 22,'W': 23,'X': 24,'Y': 25,'Z': 26 }
    for i in str_list:
        index += 1
        sum_w = 0
        for j in i:
            sum_w += dict_val[j]
        sum_t += sum_w * index
#         print(i, sum_w * index)
    return sum_t
    
print(value(names()))
value(names())
print("t = {:.5f} seg".format(time.time() - start))
# 871198282
# t = 0.01753 seg
a = ['adsaf', 'ewrwe' 'asdf ' 'qwer ']
a.sort()
a
# ['adsaf', 'ewrweasdf qwer ']
sorted(a)
# ['adsaf', 'ewrweasdf qwer ']
