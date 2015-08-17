public boolean modThree(int[] nums) {
  boolean odd = false;
  boolean even = false;
  int count = 0;
  int l = nums.length;

  for (int i = 0; i<l; i++)
    if (nums[i]%2 == 0 && even){
      count++;
      if (count == 3) return true;
    }
    else if (nums[i]%2 == 0 && !even){
      count = 1;
      even = true;
      odd = false;
    }
    else if (nums[i]%2 == 1 && odd){
      count++;
      if (count == 3) return true;
    }
    else
    {
      count = 1;
      odd = true;
      even = false;
    }

  return count == 3;

}