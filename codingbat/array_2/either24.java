public boolean either24(int[] nums) {
  boolean n2 = false;
  boolean n4 = false;

  for (int i = 0; i < nums.length-1; i++)
  {
    if (nums[i] == 2 && nums[i+1] == 2) n2 = true;
    if (nums[i] == 4 && nums[i+1] == 4) n4 = true;
  }

  return n2 ^ n4;
}