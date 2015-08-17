public boolean sameEnds(int[] nums, int len) {
  if (len == 0) return true;
  int[] a = Arrays.copyOfRange(nums, 0, len);
  int[] b = Arrays.copyOfRange(nums, nums.length-len, nums.length);
  int[] c = {1, 1};

  for (int i = 0; i < len; i++)
    if (a[i] != b[i]) return false;

  return true;
}
