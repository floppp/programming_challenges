public String changeXY(String str) {
  if (str.length() == 0)
    return "";
  else if (str.charAt(0) == 'x')
    return "y" + changeXY(str.substring(1, str.length()));
  else
    return str.substring(0, 1) + changeXY(str.substring(1, str.length()));
}