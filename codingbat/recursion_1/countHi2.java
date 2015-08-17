public int countHi2(String str) {
  if (str.length() < 2) return 0;
  else
    if (str.charAt(0) == 'x')
      return (str.charAt(1) == 'x') ? countHi2(str.substring(1)) : countHi2(str.substring(2));
    else
      return str.startsWith("hi") ? 1 + countHi2(str.substring(2)) : countHi2(str.substring(1));
  
}
