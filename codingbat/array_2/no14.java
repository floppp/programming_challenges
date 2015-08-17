public boolean no14(int[] nums) {
  return contiene1(nums) ^ contiene4(nums) ||
         (!contiene1(nums) && !contiene4(nums));
}

public boolean contiene1(int[] nums)
{
  for (int i = 0; i < nums.length; i++)
    if (nums[i] == 1)
      return true;

  return false;
}

public boolean contiene4(int[] nums)
{
  for (int i = 0; i < nums.length; i++)
    if (nums[i] == 4)
      return true;

  return false;
}
