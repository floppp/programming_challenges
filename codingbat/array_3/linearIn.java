public boolean linearIn(int[] outer, int[] inner)
{
  int lenO = outer.length;
  int lenI = inner.length;
  int i = 0, j = 0;
  boolean allIn = true;

  while (i < lenO && j < lenI)
  {
    if (inner[j] == outer[i])
    {
      i++;
      j++;
    } else
      i++;
  }

  return j == lenI;
}
