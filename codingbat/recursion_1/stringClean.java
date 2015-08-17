public String stringClean(String str) {
  if (str.length() == 1) return str;
  else
    if (str.charAt(0) != str.charAt(1))
      return str.substring(0,1) + stringClean(str.substring(1, str.length()));
    else
      return stringClean(str.substring(1, str.length()));
}
