public String parenBit(String str) {
  if (str.length() < 2) return "";
  else
    if (str.charAt(0) == '(')
      if (str.charAt(str.length()-1) == ')')
        return str;
      else
        return parenBit(str.substring(0, str.length()-1));
    else
      return parenBit(str.substring(1));
}
