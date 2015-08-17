public boolean twoTwo(int[] nums)
{
  boolean next2 = true;

  if (nums.length == 0)
    return true;
  if (nums.length == 1 && nums[0] == 2)
    return false;
  else if (nums.length == 1 && nums[0] != 2)
    return true;

  for (int i = 1; i < nums.length - 1; i++)
    if (nums[i] == 2 && nums[i-1] != 2 && nums[i] == 2 && nums[i+1] != 2)
      next2 = false;

  if (nums.length == 1)
    return false;

  if (nums[nums.length-1] == 2 && nums[nums.length-2] != 2)
    next2 = false;

  return next2;
}