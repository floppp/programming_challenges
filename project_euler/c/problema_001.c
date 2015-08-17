#include <stdio.h>
#include <time.h>
/*
If we list all the natural numbers below 10 that are
multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */

int const max = 1000;

// static inline int suma_divisores(int);
int suma_divisores(int);

void main()
{
    clock_t start = clock();
    int i, sum;

    for (i = 0; i < 1000000; i++)
        sum = suma_divisores(max);

    printf("%d\n", sum);

    printf("Tiempo transcurrido: %f seg\n", ((double)clock() - start) /
            CLOCKS_PER_SEC);
}

// static inline int suma_divisores(int n)
int suma_divisores(int n)
{
    int j, sum;

    sum = 0;
    for (j = 0; j < max; j++)
        if (j % 3 == 0 || j % 5 == 0)
            sum += j;

    return sum;
}

/*
Calculo 1.000.000 de veces,  static inline -> 3.013283 s
Calculo 1.000.000 de veces con referentcia -> 3.006027 s

PARA TODOS LOS EFECTOS EN ESTE CASO LO MISMO
 */