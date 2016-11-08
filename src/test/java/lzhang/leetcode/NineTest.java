package lzhang.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NineTest {
  @Test
  public void test(){
    Nine inst=new Nine();
    assertTrue(inst.isPalindrome(121));
    assertTrue(inst.isPalindrome(1221));
    assertTrue(inst.isPalindrome(0));
    assertFalse(inst.isPalindrome(-12));
  }
}
