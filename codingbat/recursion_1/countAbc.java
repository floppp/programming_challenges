public int countAbc(String str) {
  if (str.length() < 3) return 0;
  else
    if (str.substring(0, 3).equals("abc"))
      return 1 + countAbc(str.substring(3, str.length()));
    else if (str.substring(0, 3).equals("aba"))
      return 1 + countAbc(str.substring(2, str.length()));
    else
      return countAbc(str.substring(1, str.length()));
}
