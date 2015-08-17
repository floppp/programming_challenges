public int[] pre4(int[] nums) {
  int i = 0;
  while (nums[i++] != 4);

  int[] v = new int[i-1];
  for (int j = 0; j < i-1; j++)
    v[j] = nums[j];

  return v;
}
