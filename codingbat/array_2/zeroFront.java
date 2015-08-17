public int[] zeroFront(int[] nums) {
  int ini = 0;
  int l = nums.length;
  int end = l - 1;
  int aux;
  if (l == 0) return nums;
  while (nums[ini] == 0)
      ini++;
  while (ini < end)
  {
    if (nums[end] == 0)
    {
      aux = nums[end];
      nums[end] = nums[ini];
      nums[ini] = aux;

    }
    end--;
    while (nums[ini] == 0)
      ini++;
  }

  return nums;
}