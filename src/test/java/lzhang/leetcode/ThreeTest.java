package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThreeTest {
  @Test
  public void test(){
    Three inst=new Three();
    assertEquals(3,inst.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1,inst.lengthOfLongestSubstring("bbbbb"));
    assertEquals(3,inst.lengthOfLongestSubstring("pwwkew"));
    assertEquals(7,inst.lengthOfLongestSubstring("bpfbhmipx"));
  }
}
