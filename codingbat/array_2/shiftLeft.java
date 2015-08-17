public int[] shiftLeft(int[] nums) {
  if (nums.length == 0) return nums;
  int aux = nums[0];
  for (int i = 0; i < nums.length - 1; i++)
    nums[i] = nums[i + 1];
  nums[nums.length - 1] = aux;

  return nums;
}
