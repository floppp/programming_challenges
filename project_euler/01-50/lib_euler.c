#include <math.h>

int esPrimo(long long int n)
{
    long i;

    for (i = 2; i < (int)floor(sqrt(n)) + 1; i++)
        if (n % i == 0)
            return 0;
    return 1;
}