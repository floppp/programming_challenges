public int[] fix45(int[] nums)
{
  int len = nums.length;
  int[] array = new int[len];
  int aux = 0;

  for (int i = 0; i < len; ++i)
  {
    if (nums[i] == 4)
    {
      array[i] = 4;
      array[i+1] = 5;
    } else if (nums[i] != 5)
    aux = nums[i];
  }

  for (int i = 0; i < len; ++i)
    if (array[i] == 0)
      array[i] = aux;

    return array;
  }