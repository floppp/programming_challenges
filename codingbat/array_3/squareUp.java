public int[] squareUp(int n)
{
  int[] res = new int[n*n];
  int k = 0, l = 2;

  for (int i = 1; i < n+1; i++)
  {
    for (int j = n; j > 0; j--)
    {
      if (j < l)
        res[k] = j;
      k++;
    }
    l++;
  }

  return res;
}
