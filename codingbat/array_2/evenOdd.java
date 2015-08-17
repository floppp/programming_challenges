public int[] evenOdd(int[] nums) {
  int j = nums.length - 1;
  int aux = 0;
  for (int i = 0; i < nums.length; i++)
  {
    if (nums[i]%2 == 1)
    {
      while (nums[j]%2==1 && j > i) {j--;}
      aux = nums[i];
      nums[i] = nums[j];
      nums[j] = aux;

    }
    if (j == -1) break;
  }
  return nums;
}
