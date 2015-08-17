public int[] notAlone(int[] nums, int val)
{
  for (int i = 1; i < nums.length - 1; i++)
    if (nums[i] == val && isAlone(nums[i-1], nums[i], nums[i+1]))
      nums[i] = max(nums[i-1], nums[i+1]);

  return nums;
}

public boolean isAlone(int a, int b, int c)
{
  return b != a && b != c;
}

public int max(int a, int b)
{
  return a > b ? a : b;
}
