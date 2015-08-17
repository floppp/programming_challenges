public int[] tenRun(int[] nums) {
  int l = nums.length;
  boolean cambia = false;
  int n = 0;

  for (int i = 0; i < l; i++)
    if (nums[i] % 10 == 0)
    {
      cambia = true;
      n = nums[i];
    }
    else if (cambia)
      nums[i] = n;

  return nums;

}
