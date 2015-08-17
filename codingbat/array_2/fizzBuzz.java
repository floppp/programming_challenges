public String[] fizzBuzz(int start, int end)
{
  int N = end - start;
  String[] string = new String[N];

  for (int i = 0; i < N; i++)
  {
    if (start % 3 == 0)
    {
      if (start % 5 != 0)
        string[i] = "Fizz";
      else
        string[i] = "FizzBuzz";
      start++;
    }
    else if (start % 5 == 0)
    {
      string[i] = "Buzz";
      start++;
    }
    else
      string[i] = start++ + "";
  }

    return string;
}
