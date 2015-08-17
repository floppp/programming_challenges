public int maxSpan(int[] nums) {
  int l = nums.length;
  if (l == 0) return 0;
  int max = 0;
  int aux;
  for (int i=0; i<l; i++)
    for (int j = l-1; j >= i; j--)
    {
      if (nums[i]==nums[j])
      {
        aux = j - i;
        if (aux > max)
          max = aux;
      }
    }

    return max + 1;
}
