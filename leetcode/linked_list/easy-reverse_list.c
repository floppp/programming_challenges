#include <stdlib.h>
#include <stdio.h>

typedef struct list_node {
    int value;
    struct list_node* next;
} list_node;

static void print_list_node(list_node* ls);
static list_node* reverse(list_node* ls);

int main(int argc, char const *argv[])
{
    list_node l1 = { 1, NULL };
    list_node l2 = { 2, &l1 };
    list_node l3 = { 3, &l2 };
    list_node l4 = { 4, &l3 };
    list_node l5 = { 5, &l4 };

    print_list_node(&l5);

    list_node* reversed = reverse(&l5);

    print_list_node(reversed);

    return 0;
}

static list_node* reverse(list_node *ls)
{
    list_node* prev = NULL;
    list_node* next = NULL;

    while (ls != NULL) {
        next = ls->next;
        ls->next = prev;
        prev = ls;
        ls = next;
    }

    return prev;
}

static void print_list_node(list_node* ls)
{
    list_node* head = ls;
    while (head != NULL) {
        printf("%d - ", head->value);
        head = head->next;
    }

    printf(" NULL\n");
}
