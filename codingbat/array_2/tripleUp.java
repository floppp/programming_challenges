public boolean tripleUp(int[] nums) {
  int j = 0;

  for (int i = 1; i < nums.length; i++)
  {
    if (nums[i] == (nums[i-1] + 1))
    {
      j++;
      if (j == 2)
        return true;
    } else
      j = 0;
  }

  return false;
}
