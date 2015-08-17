#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include "lib_euler.h"

/*
   71
   839
   1471
   6857
   Tiempo transcurrido: 0.010727 seg
   10.7 ms, 10 veces mas rapido que Scala

   Cambiando el for para probar solo con impares...
   obviamente a la mitad
   Tiempo transcurrido: 0.005397 seg
   5.397 ms

   Hacerlo tambien en esPrimo no mejora mucho al
   tener que hacer pocas comparaciones

   Sacar la funcion esPrimo a libreria no afecta...
   bendito compilador
*/

long long int N = 600851475143;

/* No mejora por hacerlo static inline */
// int esPrimo(long long int);

int main(int args, char** argv)
{
    clock_t start = clock();

    long i;

    for (i = 3; i < (int)floor(sqrt(N)) + 1; i += 2)
        if (!(N % i) &&  esPrimo(i))
            printf("%d\n", i);

    printf("Tiempo transcurrido: %f seg\n", ((double)clock() - start) /
            CLOCKS_PER_SEC);
    return ;
}