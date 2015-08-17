public boolean array220(int[] nums, int index) {
  if (index >= nums.length - 1) return false;
  else
    if (10*nums[index] == nums[index+1])
      return true;
    else
      return array220(nums, index + 1);
}
