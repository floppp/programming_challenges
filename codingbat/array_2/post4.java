public int[] post4(int[] nums) {
  int l = nums.length;
  int[] v = new int[0];
  if (l > 0)
    for (int i = l-1; i >= 0; i--)
      if (nums[i] == 4)
        return Arrays.copyOfRange(nums, i+1, l);
  return v;
}
