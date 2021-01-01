#include <stdlib.h>
#include <stdio.h>

typedef struct TreeNode {
  int val;
  struct TreeNode *left;
  struct TreeNode *right;
} node;

int maxDepth(struct TreeNode* root)
{
  if (root == NULL) return 0;

  int s_left = maxDepth(root->left);
  int s_right = maxDepth(root->right);

  return s_left > s_right ? ++s_left : ++s_right;
}

int main(int argc, char const *argv[])
{
  node t5 = { 15, NULL, NULL };
  node t4 = { 7, NULL, NULL };
  node t3 = { 20, &t5, &t4 };
  node t2 = { 9, NULL, NULL };
  node t1 = { 3, &t2, &t3 };

  printf("%d\n", maxDepth(&t1));

  int a = 9 / 2;
  printf("%d\n", a);

  return 0;
}
