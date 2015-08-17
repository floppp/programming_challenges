public int[] seriesUp(int n)
{
  int len = 0;
  for (int i = 1; i < n + 1; i++)
    len += i;

  int[] res = new int[len];
  int k = 0;

  for (int i = 1; i < n + 1; i++)
    for (int j = 1; j < i + 1; j++)
      res[k++] = j;

  return res;
}
