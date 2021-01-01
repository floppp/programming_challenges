#include <stdlib.h>
#include <stdio.h>

int isBadVersion(int version)
{
  if (version >= 1702766719) return 1;
  else return 0;
}

int binary_search(int l, int h)
{
  int m = h/2 + l/2;

  if (h < l) return -1;
  else if (h == l) return l;


  if (m >= 1 && isBadVersion(m) && !isBadVersion(m-1)) return m;
  else if (!isBadVersion(m)) return binary_search(++m, h);
  else return binary_search(l, m);
}

int firstBadVersion(int n)
{
  return binary_search(1, n);
}

int main(int argc, char const *argv[])
{
  printf("%d\n", firstBadVersion(2126753390));
  return 0;
}