public boolean isEverywhere(int[] nums, int val) {
  for (int i = 0; i < nums.length - 1; i++)
  {
    if (nums[i] != val && (i < nums.length && nums[i+1] != val))
      return false;

  }
  return true;
}
