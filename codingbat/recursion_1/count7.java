public int count7(int n) {
  if (n < 7) return 0;
  else return (n % 10 == 7 ? 1 : 0) + count7(n / 10);
}