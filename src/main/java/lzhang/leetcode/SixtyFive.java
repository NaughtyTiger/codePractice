package lzhang.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixtyFive {
  public boolean isNumber(String s) {
    s=s.trim();
    long start=System.currentTimeMillis();
    Pattern pattern=Pattern
        .compile("(\\+|-)?(\\.[0-9]+|[0-9]+(\\.[0-9]*)?)(e(\\+|-)?[0-9]+)?"); // very slow
    long end=System.currentTimeMillis();
    System.out.println(end-start);

    Matcher matcher=pattern.matcher(s);
    return matcher.matches();
  }
}
