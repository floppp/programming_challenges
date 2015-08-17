public int maxMirror(int[] nums)
{
    int max = 0;
    int len = nums.length;

    for (int i = 0; i < len; ++i)
        for (int j = max + 1; j < len - i + 1; ++j)
            for (int k = i; k < len - j + 1; ++k)
            {
                boolean mir = true;
                for (int m = 0; mir && m < j; ++m)
                    mir = nums[i + m] == nums[k + j - m - 1];
                if (mir)
                    max = j;
            }

    return max;
}

