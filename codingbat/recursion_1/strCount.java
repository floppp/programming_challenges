public int strCount(String str, String sub) {
  if (str.length() < sub.length()) return 0;
  else
    if (str.startsWith(sub))
      return 1 + strCount(str.substring(sub.length()), sub);
    else
      return strCount(str.substring(1), sub);
}
