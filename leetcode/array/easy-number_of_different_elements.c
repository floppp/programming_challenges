#include <stdlib.h>
#include <stdio.h>


static int number_of_elements(int* ns, int s);
static void print_int_array(int* ns, size_t size);

int main(int args, char** argv)
{
	int s = 20;
	int ns[20] = {0, 0, 1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 9};
	int new_size = number_of_elements(ns, s);

	printf("new size: %d\n", new_size);

	print_int_array(ns, new_size);

	return 0;
}

static void print_int_array(int* ns, size_t size)
{
	for (int i = 0; i < size; i++)
	{
		printf("%d, ", ns[i]);
	}
	printf("\n");

}

static int number_of_elements(int* ns, int s)
{
	if (s <= 1) return s;

	int i, j;

	for (i = 1, j = 0; i < s; i++)
		if (ns[i] == ns[j]) continue;
		else ns[++j] = ns[i];

	return j+1;
}
