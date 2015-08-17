# from functools import reduce
from time import time


def get_dict_squares(n):
    '''
    Función para obtener diccionario con la suma de los cuadrados
    de los dígitos de cada número en el rango especificado.
    '''
    # Lo más rápido
    res = {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6: 36,
           7: 49, 8: 64, 9: 81}
    for i in range(10, n + 1):
        res[i] = res[i // 10] + res[i % 10]
    return res
    # Más rápido que lo de debajo
    # res = {}
    # for i in range(0, n+1, 10):
    #     res[i] = sum_squares(i)
    #     for j in range(1, 10):
    #         res[i+j] = res[i] + j**2
    # return res
    # Esto a continuación, elegante pero superlento
    # return {i: sum_squares(i) for i in range(1, n+1)}


def sum_squares(n):
    '''
    Función para sumar cuadradados de los dígitos de cada número
    '''
    # return reduce(lambda x, y: int(x) + int(y)**2, '0' + str(n))
    return sum(map(lambda x: int(x)**2, str(n)))


def chain(n):
    '''
    Función que aplica la cadena a cada número hasta llegar
    a 1 u 89
    '''
    while n is not 89 and n is not 1:
        n = sum_squares(n)
    return n


def get_dict_chain(n):
    '''
    Función que devuelve diccionario con el resultado final de
    aplicar función cadena a cada número, desde 1 hasta el máximo
    valor alcanzable.
    '''
    max_sum_squares = sum_squares(n)  # esto funciona si aplicamos
    # a un rango que termine en 9
    return {i: chain(i) for i in range(1, max_sum_squares + 1)}
    # dict_squares = get_dict_squares(n)
    # print(res)
    # print(dict_squares)
    # for i in dict_squares:
    #     res[dict_squares[i]] += 1
    # return res


def get_dict_frequency(dictionary):
    '''
    Función que devuelve diccionario con las frecuencias de cada
    valor de retorno de la cadena
    '''
    limit = max(dictionary.values())
    res = {i: 0 for i in range(limit + 1)}
    for i in dictionary:
        res[dictionary[i]] += 1
    return res


if __name__ == "__main__":
    start = time()

    N = 9999999
    dict_chain = get_dict_chain(N)
    dict_squares = get_dict_squares(N)
    dict_freq = get_dict_frequency(dict_squares)

    limit = max(dict_freq.keys())
    d1 = d89 = 0
    for i in range(1, limit+1):
        if dict_chain[i] == 1:
            d1 += dict_freq[i]
        else:
            d89 += dict_freq[i]
    print('d1:', d1, 'd89:', d89, 'T:', d1+d89)

    print(time() - start, 's')
