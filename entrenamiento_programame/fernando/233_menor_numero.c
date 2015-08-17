/* LIBRERIAS */
#include <stdlib.h>
#include <stdio.h>

/* DECLARACIÓN FUNCIONES */
long long int pasarVectorNumero(int* n, int k);
int continuar(int* n);
int calculoMemoria(int* n);

/* PROGRAMA */
/**
 * @brief Calculo de forma iterativa
 *
 * Calculo de forma iterativa del menor numero la suma de cuyos indices
 * da otro numero, el menor en este caso
 *
 */
int main(int argc, char** argv)
{
    int i, j, len;
    int* vectorElementos;
    int numero;
    long long int aux;
    long long int resultado = 1;

    vectorElementos = malloc(1 * sizeof(int));
    while (1)
    {
        scanf("%d", &numero);

        len = calculoMemoria(&numero);

        // Si realloc nos da null, puede ser porque le pasamos 0,
        // por eso es necesaria la comprobacion.
        if ((vectorElementos = realloc(vectorElementos, (len == 0 ? 1 : len) * sizeof(int))) == NULL)
        {
            printf("Sin memoria suficiente\n");
            return;
        }

        if (!continuar(&numero))
            break;

        if (numero < 10)
            printf("%d\n", numero);
        else
        {
            resultado = 1;
            for (i = 1; i < len; i++)
                vectorElementos[i] = 9;

            aux = numero - 9*(len - 1);
            vectorElementos[0] = aux;

            for (i = 0; i < len; i++)
                printf("%d", vectorElementos[i]);

            printf("\n");
        }
    }
    free(vectorElementos);
    vectorElementos = NULL;

    return ;
}

// Esta funcion no hace falta, como buscamos imprimir, no numero,
// con imprimir vector nos sobra. Ademas tampoco me da bien, pero
// no voy a mirarlo ahora.
long long int pasarVectorNumero(int* n, int k)
{
    int i;
    long long int aux = 0;

    for (i = 0; i < k; i++)
        aux += 10*aux + n[i];

    return aux;
}

/**
 * @brief Calculo de tamanyo de vector
 * @param  n [description]
 * @return   [description]
 */
int calculoMemoria(int* n)
{
    int cociente = *n / 9;
    int resto = *n % 9;
    if (cociente && resto)
        return cociente + 1;
    else if (resto)
        return 1;
    return cociente;
}

int continuar(int* n)
{
    if (*n == 0)
        return 0;
    return 1;
}