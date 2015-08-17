public int[] fizzArray3(int start, int end) {
  int N = end - start;
  int[] v = new int[N];
  for (int i = 0; i < N; i++)
    v[i] = start++;

  return v;
}
