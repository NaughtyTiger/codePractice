package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiveTest {
  @Test
  public void test(){
    Five inst=new Five();
    assertEquals("a",inst.longestPalindrome("abc"));
    assertEquals("bb",inst.longestPalindrome("abb"));
    assertEquals("abba",inst.longestPalindrome("abba"));
    assertEquals("ccc",inst.longestPalindrome("ccc"));
  }
}
