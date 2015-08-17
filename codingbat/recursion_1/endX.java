public String endX(String str) {
  if (str.length() <=1) return str;
  else
    if (str.charAt(0) == 'x')
      return endX(str.substring(1, str.length())) + "x";
    else
      return str.substring(0,1) + endX(str.substring(1, str.length()));
}
