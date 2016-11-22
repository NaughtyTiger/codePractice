package lzhang.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TenTest {
  @Test
  public void test(){
    Ten inst=new Ten();
    assertFalse(inst.isMatch("aa","a"));
    assertTrue(inst.isMatch("aa", "aa"));
    assertFalse(inst.isMatch("aaa", "aa"));
    assertTrue(inst.isMatch("aaa", "a*"));
    assertTrue(inst.isMatch("aa", ".*"));
    assertTrue(inst.isMatch("ab", ".*"));
    assertFalse(inst.isMatch("ab", "."));
    assertTrue(inst.isMatch("aab","c*a*b"));
    assertFalse(inst.isMatch("ab", ".*c"));
    assertFalse(inst.isMatch("acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*"));
    assertTrue(inst.isMatch("a", "ab*"));
  }
}
