package lzhang.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eight {
  public int myAtoi(String str) {
    if (str.length()==0){
      return 0;
    }
    str=str.trim();
    if (str.charAt(0)=='+'){
      str=str.substring(1);
      if (str.length()==0 || str.charAt(0)=='-'){
        return 0;
      }
    }
    Pattern pattern=Pattern.compile("^ *-?[0-9]*");
    Matcher matcher=pattern.matcher(str);
    if (matcher.find()){
      try {
        String tmp=matcher.group(0).trim();
        tmp=tmp.replaceFirst("^-0+", "-");
        tmp=tmp.replaceFirst("^0+", "");
        return Integer.parseInt(tmp);
      } catch (NumberFormatException e){
        e.printStackTrace();
        return 0;
      }
    }
    return 0;
  }
}
