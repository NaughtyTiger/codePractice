package lzhang.leetcode;

import org.junit.Test;

public class TwentyEightTest {
  @Test
  public void test(){
    TwentyEight inst=new TwentyEight();
    System.out.println(inst.strStr("", ""));
    System.out.println(inst.strStr("abcac", "bca"));
    System.out.println(inst.strStr("abcac", "bcd"));
  }
}
