public boolean haveThree(int[] nums) {
  int count3 = 0;
  int j = 0;
  int[] p = new int[3];
  for (int i=0; i < nums.length;i++)
    if (nums[i] == 3)
      count3++;
  if (count3 == 3)
  {
    for (int i=0; i<nums.length; i++)
      if (nums[i] == 3)
        p[j++]=i;
    if (Math.abs(p[0]-p[1]) == 1 || Math.abs(p[1]-p[2]) == 1)
      return false;
    else
      return true;
  } else
    return false;
}
