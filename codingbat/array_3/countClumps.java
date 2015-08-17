public int countClumps(int[] nums)
{
  int len = nums.length;
  int i = 0, suma = 0;
  int aux;
  boolean igual;

  while (i < len - 1)
  {
    igual = false;
    if (nums[i] == nums[i + 1])
    {
      suma++;
      i++;
      while (i < len && ((aux = nums[i - 1]) == nums[i]))
        i++;

      igual = true;
    }
    if (!igual)
      i++;
  }

  return suma;
}
