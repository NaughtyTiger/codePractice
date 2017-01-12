package lzhang.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FortyFourTest {
  @Test
  public void test(){
    String test="b*****************b";
    System.out.println(test.replaceAll("\\**", "*"));
    FortyFour inst=new FortyFour();
    assertFalse(inst.isMatch("aa","a"));
    assertTrue(inst.isMatch("aa", "aa"));
    assertFalse(inst.isMatch("aaa", "aa"));
    assertFalse(inst.isMatch("aab","c*a*b"));
    assertTrue(inst.isMatch("ho", "ho**"));
    assertFalse(inst.isMatch("leetcode","*e*t?d*"));
  }
}
