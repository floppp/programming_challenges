public int sum67(int[] nums) {
  int sum = 0;
  for (int i = 0; i < nums.length; i++)
  {
    if (nums[i] == 6)
    {
      while (nums[++i] != 7);
      sum -= 7;
    }
    sum += nums[i];
  }

  return sum;
}
