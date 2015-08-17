public int[] zeroMax(int[] nums) {
  int max;

  for (int i = 0; i < nums.length; i++)
     if (nums[i] == 0)
     {
       max = 0;
       for (int j = i+1; j < nums.length; j++)
         if (nums[j] % 2 == 1)
           if (nums[j] > max)
             max = nums[j];
       nums[i] = max;
     }

  return nums;
}
