public int strDist(String str, String sub)
{
  if (str.equals("")) return 0;
  if (str.startsWith(sub))
    if (str.substring(str.length()-sub.length(), str.length()).equals(sub))
      return str.length();
    else
      return strDist(str.substring(0, str.length()-1), sub);
  else
    return strDist(str.substring(1), sub);
}