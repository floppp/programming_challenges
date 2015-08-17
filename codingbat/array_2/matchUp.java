public int matchUp(int[] nums1, int[] nums2) {
  int count = 0;
  for (int i = 0; i < nums1.length; i++)
    if (match(nums1[i], nums2[i]))
      count++;

  return count;
}

public boolean match(int num1, int num2) {
  return Math.abs(num1 - num2) == 2 ||
         Math.abs(num1 - num2) == 1;
}