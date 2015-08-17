public boolean canBalance(int[] nums)
{
  int len = nums.length;
  int sumL, sumR;
  for (int i = 0; i < len; i++)
  {
    sumL = 0;
    sumR = 0;
    for (int j = 0; j < i; j++)
      sumL += nums[j];
    for (int k = i ; k < len; k++)
      sumR += nums[k];
    if (sumL == sumR)
      return true;
  }

  return false;
}
