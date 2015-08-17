public String noX(String str) {
  if (str.length() == 0) return "";
  else
    if (str.charAt(0) == 'x') return noX(str.substring(1, str.length()));
    else return str.substring(0, 1) + noX(str.substring(1, str.length()));
}
