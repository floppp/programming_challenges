public int[] fix34(int[] nums)
{
  int len = nums.length;
  int i = 0, j = 0;
  int aux;
  j = 0;
  while (i < len - 1)
  {
    if (nums[i] == 3)
    {
      while (j < len)
      {
        if (nums[j] == 4)
        {
          aux = nums[i+1];
          nums[i+1] = nums[j];
          nums[j] = aux;
          break;
        }
        j++;
      }
    }
    i++;
  }

  return nums;
}
